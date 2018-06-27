package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.dao.HibernateUtil;
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
}
