package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.apiModels.braziliex.Order;
import com.fabiolux.gbot.api.apiModels.braziliex.Orderbook;
import com.fabiolux.gbot.api.apiModels.braziliex.TradeHistory;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.dao.controller.BraziliexDaoController;
import com.fabiolux.gbot.dao.models.BraziliexOrderbookHistory;
import com.fabiolux.gbot.dao.models.BraziliexStatus;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;
import com.fabiolux.gbot.dao.utils.BraziliexTradeHistoryImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
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
        List<Order> orders = orderbook.toOrders();
        List<BraziliexOrderbookHistory> savedOrderbooks = dao.getActiveOrderbooks(market);
        List<BraziliexOrderbookHistory> ordersNotFound = new ArrayList<>();

        for(int i=0;i<savedOrderbooks.size();i++){
            BraziliexOrderbookHistory savedOrder = savedOrderbooks.get(i);
            boolean found = false;
            for(int c=0;c<orders.size();c++){
                Order order = orders.get(c);
                if (savedOrder.getBohType().equals(order.getType().getCode()) && new BigDecimal(order.getPrice()).equals(savedOrder.getBohPrice())) {
                    found = true;
                    orders.remove(c);
                    c--;
                }
            }
            if(!found){
                ordersNotFound.add(savedOrder);
                savedOrder.setBohActive(false);
                savedOrder.setBohTerminatedTimestamp(Timestamp.from(Instant.now()));
                dao.persistEntity(savedOrder);
            }
        }

        List<BraziliexOrderbookHistory> bidsNotFound = BraziliexOrderbookHistory.getBids(ordersNotFound);
        List<BraziliexOrderbookHistory> asksNotFound = BraziliexOrderbookHistory.getAsks(ordersNotFound);

        List<Order> newAsks = Order.getAsks(orders);
        List<Order> newBids = Order.getBids(orders);
        if(asksNotFound.size()>0 || bidsNotFound.size()>0 || orders.size()>0)
            System.out.println("UPDATE MARKET: "+market.getCode());
        if(asksNotFound.size()>0 || bidsNotFound.size()>0)
            System.out.println("TERMINATED "+asksNotFound.size()+" ask(s), "+bidsNotFound.size()+" bid(s)");
        if(orders.size()>0)
            System.out.println("CREATED "+newAsks.size()+" ask(s), "+newBids.size()+" bid(S)");

        for(Order order:orders){
            BraziliexOrderbookHistory history = new BraziliexOrderbookHistory();
            history.setBohInitialAmount(new BigDecimal(order.getAmount()));
            history.setBohCurrentAmount(new BigDecimal(order.getAmount()));
            history.setBohPrice(new BigDecimal(order.getPrice()));
            history.setBohCreatedTimestamp(Timestamp.from(Instant.now()));
            history.setBohType(order.getType().getCode());
            history.setBohActive(true);
            history.setBohMarket(market.getCode());
            dao.persistEntity(history);
        }
        BraziliexStatus status = dao.getStatus();
        status.setBsLastCheck(Timestamp.from(Instant.now()));
        dao.updateStatus(status);
        dao.endTransaction(true);
    }
}