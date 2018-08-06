import db.controller as con
from IPython import display
from matplotlib import cm
from matplotlib import gridspec
from matplotlib import pyplot as plt

def priceXPrediction():
    trade_history = con.getTradeHistory();
    price_prediction = con.getPricePrediction();
    ax = trade_history.plot(x="bth_timestamp", y="bth_price")
    price_prediction.plot(ax=ax, x="bpp_prediction_created_timestamp",y="bpp_prediction_price")

def askBidsXPrice():
    asks = con.getAsks();
    bids = con.getBids();
    trade_history = con.getTradeHistory();
    
    ax = asks.plot(x="boh_created_timestamp",y="boh_price", label="asks")
    print("EXECUTE")
    bidsax = bids.plot(ax=ax,x="boh_created_timestamp",y="boh_price", label="bids")
    trade_history.plot(ax=bidsax, x="bth_timestamp",y="bth_price")
    
def marketByTime():
    marketByTimeAsk = con.getMarketByTime("ask");
    marketByTimeBid = con.getMarketByTime("bid");
    print(marketByTimeAsk.head())
    
    #axActiveOrdersAsk = marketByTimeAsk.plot( x="timeval",y="activeorders",label="activeOrders (ask)");
    #axActiveOrderBid = marketByTimeBid.plot(ax=axActiveOrdersAsk, x="timeval",y="activeorders",label="activeOrders (bid)");
    #axTotalMarket = marketByTimeAsk.plot(ax=axActiveOrderBid,x="timeval",y="totalinmarket",secondary_y=True, label="totalinmarket (ask)")
    #marketByTimeBid.plot(ax=axActiveOrderBid,x="timeval",y="totalinmarket",secondary_y=True, label="totalinmarket (bid)")
    fig, host = plt.subplots()
    par1 = host.twinx()
    par2 = host.twinx()
    par3 = host.twinx()
    print(marketByTimeAsk.describe())
    print(marketByTimeBid.describe())

    # Offset the right spine of par2.  The ticks and label have already been
    # placed on the right by twinx above.
    par2.spines["right"].set_position(("axes", 1.2))
    par3.spines["right"].set_position(("axes", 1.2))
    # Having been created by twinx, par2 has its frame off, so the line of its
    # detached spine is invisible.  First, activate the frame but make the patch
    # and spines invisible.
    # Second, show the right spine.
    par2.spines["right"].set_visible(True)
    par3.spines["right"].set_visible(True)

    p1, = host.plot(marketByTimeAsk["timeval"], marketByTimeAsk["totalinmarket"], "b-", label="totalinmarket (ask)")
    p2, = par1.plot(marketByTimeBid["timeval"], marketByTimeBid["totalinmarket"], "r-", label="totalinmarket (bid)")
    p3, = par2.plot(marketByTimeAsk["timeval"], marketByTimeAsk["activeorders"], "g-", label="activeOrders (ask)")
    p4, = par3.plot(marketByTimeBid["timeval"], marketByTimeBid["activeorders"], "y-", label="activeOrders (bid)")
    tkw = dict(size=4, width=1.5)
    host.tick_params(axis='y', colors=p1.get_color(), **tkw)
    par1.tick_params(axis='y', colors=p2.get_color(), **tkw)
    par2.tick_params(axis='y', colors=p3.get_color(), **tkw)
    par3.tick_params(axis='y', colors=p3.get_color(), **tkw)
    host.tick_params(axis='x', **tkw)

    lines = [p1, p2, p3, p4]

    host.legend(lines, [l.get_label() for l in lines])

    plt.show()
    
def totalTransactions():
    totalTransactionsBuy = con.getTotalTransactions("buy");
    totalTransactionsSell = con.getTotalTransactions("sell");
    buyax = totalTransactionsBuy.plot(x="timeval",y="medianprice",label="buy")
    totalTransactionsSell.plot(ax=buyax, x="timeval",y="medianprice",label="sell")