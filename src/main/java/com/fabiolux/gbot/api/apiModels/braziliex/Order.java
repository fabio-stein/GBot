package com.fabiolux.gbot.api.apiModels.braziliex;

import com.fabiolux.gbot.api.enums.OrderbookType;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String amount;

    private String price;

    private OrderbookType type;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public OrderbookType getType() {
        return type;
    }

    public void setType(OrderbookType type) {
        this.type = type;
    }

    public Order(Asks ask){
        this.amount = ask.getAmount();
        this.price = ask.getPrice();
        this.type = OrderbookType.ASK;
    }

    public Order(Bids bid){
        this.amount = bid.getAmount();
        this.price = bid.getPrice();
        this.type = OrderbookType.BID;
    }

    public static List<Order> getBids(List<Order> orders){
        return getOrdersByType(orders, OrderbookType.BID);
    }

    public static List<Order> getAsks(List<Order> orders){
        return  getOrdersByType(orders, OrderbookType.ASK);
    }

    public static List<Order> getOrdersByType(List<Order> orders, OrderbookType type){
        List<Order> bids = new ArrayList<>();
        for(Order order: orders)
            if(order.getType()==type)
                bids.add(order);
        return orders;
    }
}
