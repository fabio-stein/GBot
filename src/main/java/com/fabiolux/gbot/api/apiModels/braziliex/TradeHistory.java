package com.fabiolux.gbot.api.apiModels.braziliex;

public class TradeHistory
{
    private String timestamp;
    private String total;
    private String amount;
    private String price;
    private String _id;
    private String date_exec;
    private String type;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDate_exec() {
        return date_exec;
    }

    public void setDate_exec(String date_exec) {
        this.date_exec = date_exec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
