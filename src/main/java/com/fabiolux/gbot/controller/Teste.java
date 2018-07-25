package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.apiModels.braziliex.TradeHistory;
import com.fabiolux.gbot.dao.HibernateUtil;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;
import com.fabiolux.gbot.dao.models.Configuration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Teste {

    @RequestMapping("/privateCall")
    public String privateApiTest() throws Exception {
        String ret = "";
        BraziliexController controller = new BraziliexController();
        ret = controller.getExchange().getName();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String pubKey = System.getenv("BRAZILIEX_PUBLIC");
        String privKey = System.getenv("BRAZILIEX_PRIVATE");
        Long nonce = getNonce();
        String content = "nonce="+nonce+"&command=balance";
        String hmac = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, privKey).hmacHex(content);
        Call<String> call = controller.getClient().getBalance(nonce, "balance", pubKey, hmac);
        ret = call.execute().body();
        return ret;
    }

    public Long getNonce(){
        EntityManager em = HibernateUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Configuration conf = em.createQuery("SELECT c FROM Configuration c", Configuration.class).getSingleResult();
        Long nonce = conf.getConfBraziliexNonce();
        conf.setConfBraziliexNonce(nonce+1);
        em.merge(conf);
        transaction.commit();
        return nonce;
    }

    @RequestMapping("/teste")
    public String teste() throws IOException {
        BraziliexController controller = new BraziliexController();
        String ret = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ret = gson.toJson(controller.getClient().getOrderBook("xmr_brl").execute().body());
        return ret;
    }

    @RequestMapping("/teste2")
    public String teste2() throws IOException {
        BraziliexController controller = new BraziliexController();
        String ret = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ret = gson.toJson(controller.getClient().getTradeHistory("xmr_brl").execute().body());
        return ret;
    }

    @RequestMapping("/thistory")
    public String thist() throws IOException, ParseException {
        BraziliexController controller = new BraziliexController();
        String ret = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<TradeHistory> history = controller.getClient().getTradeHistory("xmr_brl").execute().body();
        List<BraziliexTradeHistory> brListHistory = new ArrayList<>();
        for(TradeHistory t:history){
            BraziliexTradeHistory bth = new BraziliexTradeHistory();
            bth.setBthTotal(new BigDecimal(t.getTotal()));
            bth.setBthAmount(new BigDecimal(t.getAmount()));
            bth.setBthPrice(new BigDecimal(t.getPrice()));
            bth.setBthMarket("xmr_brl");
            bth.setBthType(t.getType());
            bth.setBthExtId(t.get_id());
            bth.setBthTimestamp(new Timestamp(Long.valueOf(t.getTimestamp())));
            brListHistory.add(bth);
        }
        EntityManager em = HibernateUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for(BraziliexTradeHistory bth:brListHistory)
            em.persist(bth);
        transaction.commit();
        ret = gson.toJson(brListHistory);
        return ret;
    }
}
