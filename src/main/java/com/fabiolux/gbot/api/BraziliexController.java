package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.apiModels.braziliex.TradeHistory;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.api.util.BraziliexTradeHistoryImpl;
import com.fabiolux.gbot.dao.controller.BraziliexDaoController;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;

import java.io.IOException;
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
        dao.persistBraziliexTradeHistory(history);
        dao.endTransaction(true);
    }
}