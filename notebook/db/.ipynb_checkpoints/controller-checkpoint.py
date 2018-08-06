import pandas as pd
conn = None
def test():
    return  pd.read_sql_query(
        "SELECT * FROM braziliex_trade_history WHERE bth_timestamp >= (now() - interval '72 HOUR') AND bth_market = 'btc_brl'",
        conn)
def getTradeHistory():
    return pd.read_sql_query("SELECT * FROM braziliex_trade_history WHERE bth_timestamp >= (now() - interval '72 HOUR') AND bth_market = 'btc_brl'", conn);
def getPricePrediction():
    return pd.read_sql_query("SELECT * FROM braziliex_price_prediction WHERE bpp_prediction_for_timestamp >= (now() - interval '72 HOUR')", conn);

def getAsks():
    return pd.read_sql_query("SELECT *, boh_price::integer as preco FROM braziliex_orderbook_history WHERE boh_created_timestamp >= (now() - interval '12 HOUR') AND boh_market = 'btc_brl' AND boh_type = 'ask' AND boh_active = FALSE AND boh_price", conn)
def getBids():
    return pd.read_sql_query("SELECT *, boh_price::integer as preco FROM braziliex_orderbook_history WHERE boh_created_timestamp >= (now() - interval '12 HOUR') AND boh_market = 'btc_brl' AND boh_type = 'bid' AND boh_active = FALSE", conn)

def getMarketByTime(marketType):
    return pd.read_sql_query("""WITH tempos as(
SELECT to_timestamp(floor((extract('epoch' from boh_created_timestamp) / 600 )) * 600) 
AT TIME ZONE 'UTC' as timeval
FROM braziliex_orderbook_history
WHERE boh_type = '{mkType}'
GROUP BY timeval
ORDER BY timeval DESC)
SELECT count(*) as activeOrders, sum(boh_initial_amount*boh_price) as totalinmarket, timeval FROM braziliex_orderbook_history INNER JOIN tempos ON boh_created_timestamp <= timeval AND boh_terminated_timestamp >= timeval
WHERE timeval >= (now() - interval '24 HOUR')
AND boh_type = '{mkType}'
GROUP BY timeval
ORDER BY timeval ASC""".format(mkType=marketType), conn);

def getTotalTransactions(typeBuySell):
    return pd.read_sql_query("""WITH tempos as(
SELECT to_timestamp(floor((extract('epoch' from bth_timestamp) / 600 )) * 600) 
AT TIME ZONE 'UTC' as timeval
FROM braziliex_trade_history
GROUP BY timeval
ORDER BY timeval DESC)
SELECT count(*) as activeOrders, avg(bth_price) as medianprice, timeval FROM braziliex_trade_history INNER JOIN tempos ON bth_timestamp <= timeval AND bth_timestamp+'00:10:00' >= timeval
WHERE timeval >= (now() - interval '24 HOUR')
AND bth_type = '{tType}'
GROUP BY timeval
ORDER BY timeval DESC""".format(tType=typeBuySell), conn)