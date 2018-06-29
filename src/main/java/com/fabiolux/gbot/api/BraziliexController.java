package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.apiModels.braziliex.Asks;
import com.fabiolux.gbot.api.apiModels.braziliex.Orderbook;
import com.fabiolux.gbot.api.apiModels.braziliex.TradeHistory;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.api.enums.OrderbookType;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.api.util.BraziliexTradeHistoryImpl;
import com.fabiolux.gbot.dao.controller.BraziliexDaoController;
import com.fabiolux.gbot.dao.models.BraziliexOrderbookHistory;
import com.fabiolux.gbot.dao.models.BraziliexStatus;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BraziliexController extends AbstractClientAPI<Braziliex, BrazilliexApi> {
    private BraziliexDaoController dao = new BraziliexDaoController();

    @Override
    public Braziliex instantiateExchange() {
        return new Braziliex();
    }

    @Override
    public Class<BrazilliexApi> getApiClass() {
        return BrazilliexApi.class;
    }

    public void updateTradeHistory(Market market) throws IOException {
        List<TradeHistory> data = getClient().getTradeHistory(market.getCode()).execute().body();
        List<BraziliexTradeHistory> history = BraziliexTradeHistory.tradeHistoryToBraziliexTradeHistory(data, market);
        BraziliexTradeHistory lastInDb = dao.getLatestByTime(market);
        if(lastInDb!=null){
            history = BraziliexTradeHistory.filterByTime(history, lastInDb.getBthTimestamp(), BraziliexTradeHistoryImpl.BTH_FILTER_TYPE.GREATER_THAN);
        }
        dao.beginTransaction();
        if(history.size()>0)
            System.out.println("Executed "+history.size()+" order(s)");
        dao.persistBraziliexTradeHistory(history);
        dao.endTransaction(true);
    }

    public void updateOrderBook(Market market) throws IOException {
        Orderbook orderbook = getClient().getOrderBook(market.getCode()).execute().body();
        dao.beginTransaction();
        List<Asks> asks = new ArrayList<>(Arrays.asList(orderbook.getAsks()));
        List<BraziliexOrderbookHistory> savedOrderbooks = dao.getActiveOrderbooks();
        int notFound = 0;

        for(int i=0;i<savedOrderbooks.size();i++){
            BraziliexOrderbookHistory order = savedOrderbooks.get(i);
            boolean found = false;
            for(int c=0;c<asks.size();c++){
                Asks ask = asks.get(c);
                if(new BigDecimal(ask.getPrice()).equals(order.getBohPrice())){
                    found = true;
                    asks.remove(c);
                    c--;
                }
            }
            if(!found){
                order.setBohActive(false);
                order.setBohTerminatedTimestamp(Timestamp.from(Instant.now()));
                dao.persistEntity(order);
                notFound++;
            }
        }
        if(notFound>0)
            System.out.println(notFound+" order(s) terminated");
        if(asks.size()>0)
            System.out.println(asks.size()+" order(s) created");
        for(Asks ask:asks) {
            BraziliexOrderbookHistory history = new BraziliexOrderbookHistory();
            history.setBohInitialAmount(new BigDecimal(ask.getAmount()));
            history.setBohCurrentAmount(new BigDecimal(ask.getAmount()));
            history.setBohPrice(new BigDecimal(ask.getPrice()));
            history.setBohCreatedTimestamp(Timestamp.from(Instant.now()));
            history.setBohType(OrderbookType.ASK.getCode());
            history.setBohActive(true);
            dao.persistEntity(history);
        }
        BraziliexStatus status = dao.getStatus();
        status.setBsLastCheck(Timestamp.from(Instant.now()));
        dao.updateStatus(status);
        dao.endTransaction(true);
    }
}