package com.fabiolux.gbot.dao.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_price_prediction", schema = "public", catalog = "gbot")
public class BraziliexPricePrediction {
    private Long bppId;
    private String bppMarket;
    private Timestamp bppPredictionCreatedTimestamp;
    private Timestamp bppPredictionForTimestamp;
    private BigDecimal bppPredictionPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bpp_id", nullable = false)
    public Long getBppId() {
        return bppId;
    }

    public void setBppId(Long bppId) {
        this.bppId = bppId;
    }

    @Basic
    @Column(name = "bpp_market", nullable = false, length = -1)
    public String getBppMarket() {
        return bppMarket;
    }

    public void setBppMarket(String bppMarket) {
        this.bppMarket = bppMarket;
    }

    @Basic
    @Column(name = "bpp_prediction_created_timestamp", nullable = false)
    public Timestamp getBppPredictionCreatedTimestamp() {
        return bppPredictionCreatedTimestamp;
    }

    public void setBppPredictionCreatedTimestamp(Timestamp bppPredictionCreatedTimestamp) {
        this.bppPredictionCreatedTimestamp = bppPredictionCreatedTimestamp;
    }

    @Basic
    @Column(name = "bpp_prediction_for_timestamp", nullable = false)
    public Timestamp getBppPredictionForTimestamp() {
        return bppPredictionForTimestamp;
    }

    public void setBppPredictionForTimestamp(Timestamp bppPredictionForTimestamp) {
        this.bppPredictionForTimestamp = bppPredictionForTimestamp;
    }

    @Basic
    @Column(name = "bpp_prediction_price", nullable = false, precision = 0)
    public BigDecimal getBppPredictionPrice() {
        return bppPredictionPrice;
    }

    public void setBppPredictionPrice(BigDecimal bppPredictionPrice) {
        this.bppPredictionPrice = bppPredictionPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BraziliexPricePrediction that = (BraziliexPricePrediction) o;
        return Objects.equals(bppId, that.bppId) &&
                Objects.equals(bppMarket, that.bppMarket) &&
                Objects.equals(bppPredictionCreatedTimestamp, that.bppPredictionCreatedTimestamp) &&
                Objects.equals(bppPredictionForTimestamp, that.bppPredictionForTimestamp) &&
                Objects.equals(bppPredictionPrice, that.bppPredictionPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bppId, bppMarket, bppPredictionCreatedTimestamp, bppPredictionForTimestamp, bppPredictionPrice);
    }
}
