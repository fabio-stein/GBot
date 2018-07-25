package com.fabiolux.gbot.dao.utils;

import com.fabiolux.gbot.api.apiModels.braziliex.TradeHistory;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class BraziliexTradeHistoryImpl {
    public static List<BraziliexTradeHistory> tradeHistoryToBraziliexTradeHistory(List<TradeHistory> history, Market market){
        List<BraziliexTradeHistory> bthList = new ArrayList<>();
        for(TradeHistory t:history){
            BraziliexTradeHistory bth = new BraziliexTradeHistory();
            bth.setBthTotal(new BigDecimal(t.getTotal()));
            bth.setBthAmount(new BigDecimal(t.getAmount()));
            bth.setBthPrice(new BigDecimal(t.getPrice()));
            bth.setBthMarket(market.getCode());
            bth.setBthType(t.getType());
            bth.setBthExtId(t.get_id());
            bth.setBthTimestamp(new Timestamp(Long.valueOf(t.getTimestamp())));
            bthList.add(bth);
        }
        return bthList;
    }

    public static BraziliexTradeHistory getLastByTime(List<BraziliexTradeHistory> history){
        Timestamp ts = null;
        Integer latest = null;
        for(int i=0;i<history.size();i++) {
            BraziliexTradeHistory h = history.get(i);
            if (ts == null || ts.before(h.getBthTimestamp())) {
                ts = h.getBthTimestamp();
                latest = i;
            }
        }
        return (latest!=null)?history.get(latest):null;
    }

    public static BraziliexTradeHistory getFirstByTime(List<BraziliexTradeHistory> history){
        Timestamp ts = null;
        Integer first = null;
        for(int i=0;i<history.size();i++) {
            BraziliexTradeHistory h = history.get(i);
            if (ts == null || ts.after(h.getBthTimestamp())) {
                ts = h.getBthTimestamp();
                first = i;
            }
        }
        return (first!=null)?history.get(first):null;
    }

    public enum BTH_FILTER_TYPE{
        GREATER_THAN,
        LOWER_THAN
    }
    public static List<BraziliexTradeHistory> filterByTime(List<BraziliexTradeHistory> history, Timestamp tsFilter, BTH_FILTER_TYPE filter){
        for(int i=0;i<history.size();i++){
            BraziliexTradeHistory h = history.get(i);
            boolean remove = false;
            if(filter==BTH_FILTER_TYPE.GREATER_THAN) {
                if (!(tsFilter.before(h.getBthTimestamp())))
                    remove = true;
            } else if(filter==BTH_FILTER_TYPE.LOWER_THAN){
                if(!(tsFilter.before(h.getBthTimestamp())))
                    remove = true;
            }
            if(remove) {
                history.remove(i);
                i--;
            }
        }
        return history;
    }
}
