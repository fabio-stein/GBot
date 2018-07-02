package com.fabiolux.gbot.dao.models;

import com.fabiolux.gbot.dao.utils.BraziliexTradeHistoryImpl;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_trade_history", schema = "public", catalog = "gbot")
public class BraziliexTradeHistory extends BraziliexTradeHistoryImpl {
    private Integer bthId;
    private BigDecimal bthPrice;
    private BigDecimal bthAmount;
    private BigDecimal bthTotal;
    private Timestamp bthTimestamp;
    private String bthType;
    private String bthExtId;
    private String bthMarket;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bth_id", nullable = false)
    public Integer getBthId() {
        return bthId;
    }

    public void setBthId(Integer bthId) {
        this.bthId = bthId;
    }

    @Basic
    @Column(name = "bth_price", nullable = false, precision = 0)
    public BigDecimal getBthPrice() {
        return bthPrice;
    }

    public void setBthPrice(BigDecimal bthPrice) {
        this.bthPrice = bthPrice;
    }

    @Basic
    @Column(name = "bth_amount", nullable = false, precision = 0)
    public BigDecimal getBthAmount() {
        return bthAmount;
    }

    public void setBthAmount(BigDecimal bthAmount) {
        this.bthAmount = bthAmount;
    }

    @Basic
    @Column(name = "bth_total", nullable = false, precision = 0)
    public BigDecimal getBthTotal() {
        return bthTotal;
    }

    public void setBthTotal(BigDecimal bthTotal) {
        this.bthTotal = bthTotal;
    }

    @Basic
    @Column(name = "bth_timestamp", nullable = false)
    public Timestamp getBthTimestamp() {
        return bthTimestamp;
    }

    public void setBthTimestamp(Timestamp bthTimestamp) {
        this.bthTimestamp = bthTimestamp;
    }

    @Basic
    @Column(name = "bth_type", nullable = false, length = -1)
    public String getBthType() {
        return bthType;
    }

    public void setBthType(String bthType) {
        this.bthType = bthType;
    }

    @Basic
    @Column(name = "bth_ext_id", nullable = false, length = -1)
    public String getBthExtId() {
        return bthExtId;
    }

    public void setBthExtId(String bthExtId) {
        this.bthExtId = bthExtId;
    }

    @Basic
    @Column(name = "bth_market", nullable = false, length = -1)
    public String getBthMarket() {
        return bthMarket;
    }

    public void setBthMarket(String bthMarket) {
        this.bthMarket = bthMarket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BraziliexTradeHistory that = (BraziliexTradeHistory) o;
        return Objects.equals(bthId, that.bthId) &&
                Objects.equals(bthPrice, that.bthPrice) &&
                Objects.equals(bthAmount, that.bthAmount) &&
                Objects.equals(bthTotal, that.bthTotal) &&
                Objects.equals(bthTimestamp, that.bthTimestamp) &&
                Objects.equals(bthType, that.bthType) &&
                Objects.equals(bthExtId, that.bthExtId) &&
                Objects.equals(bthMarket, that.bthMarket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bthId, bthPrice, bthAmount, bthTotal, bthTimestamp, bthType, bthExtId, bthMarket);
    }
}
