package com.fabiolux.gbot.dao.models;

import com.fabiolux.gbot.dao.utils.BraziliexOrderbookHistoryImpl;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_orderbook_history", schema = "public", catalog = "gbot")
public class BraziliexOrderbookHistory extends BraziliexOrderbookHistoryImpl {
    private Long bohId;
    private BigDecimal bohInitialAmount;
    private BigDecimal bohCurrentAmount;
    private BigDecimal bohPrice;
    private Timestamp bohCreatedTimestamp;
    private Timestamp bohTerminatedTimestamp;
    private String bohType;
    private Integer bohTerminatedReason;
    private Boolean bohActive;
    private String bohMarket;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boh_id", nullable = false)
    public Long getBohId() {
        return bohId;
    }

    public void setBohId(Long bohId) {
        this.bohId = bohId;
    }

    @Basic
    @Column(name = "boh_initial_amount", nullable = false, precision = 0)
    public BigDecimal getBohInitialAmount() {
        return bohInitialAmount;
    }

    public void setBohInitialAmount(BigDecimal bohInitialAmount) {
        this.bohInitialAmount = bohInitialAmount;
    }

    @Basic
    @Column(name = "boh_current_amount", nullable = false, precision = 0)
    public BigDecimal getBohCurrentAmount() {
        return bohCurrentAmount;
    }

    public void setBohCurrentAmount(BigDecimal bohCurrentAmount) {
        this.bohCurrentAmount = bohCurrentAmount;
    }

    @Basic
    @Column(name = "boh_price", nullable = false, precision = 0)
    public BigDecimal getBohPrice() {
        return bohPrice;
    }

    public void setBohPrice(BigDecimal bohPrice) {
        this.bohPrice = bohPrice;
    }

    @Basic
    @Column(name = "boh_created_timestamp", nullable = false)
    public Timestamp getBohCreatedTimestamp() {
        return bohCreatedTimestamp;
    }

    public void setBohCreatedTimestamp(Timestamp bohCreatedTimestamp) {
        this.bohCreatedTimestamp = bohCreatedTimestamp;
    }

    @Basic
    @Column(name = "boh_terminated_timestamp", nullable = true)
    public Timestamp getBohTerminatedTimestamp() {
        return bohTerminatedTimestamp;
    }

    public void setBohTerminatedTimestamp(Timestamp bohTerminatedTimestamp) {
        this.bohTerminatedTimestamp = bohTerminatedTimestamp;
    }

    @Basic
    @Column(name = "boh_type", nullable = false, length = -1)
    public String getBohType() {
        return bohType;
    }

    public void setBohType(String bohType) {
        this.bohType = bohType;
    }

    @Basic
    @Column(name = "boh_terminated_reason", nullable = true)
    public Integer getBohTerminatedReason() {
        return bohTerminatedReason;
    }

    public void setBohTerminatedReason(Integer bohTerminatedReason) {
        this.bohTerminatedReason = bohTerminatedReason;
    }

    @Basic
    @Column(name = "boh_active", nullable = false)
    public Boolean getBohActive() {
        return bohActive;
    }

    public void setBohActive(Boolean bohActive) {
        this.bohActive = bohActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BraziliexOrderbookHistory that = (BraziliexOrderbookHistory) o;
        return Objects.equals(bohId, that.bohId) &&
                Objects.equals(bohInitialAmount, that.bohInitialAmount) &&
                Objects.equals(bohCurrentAmount, that.bohCurrentAmount) &&
                Objects.equals(bohPrice, that.bohPrice) &&
                Objects.equals(bohCreatedTimestamp, that.bohCreatedTimestamp) &&
                Objects.equals(bohTerminatedTimestamp, that.bohTerminatedTimestamp) &&
                Objects.equals(bohType, that.bohType) &&
                Objects.equals(bohTerminatedReason, that.bohTerminatedReason) &&
                Objects.equals(bohActive, that.bohActive);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bohId, bohInitialAmount, bohCurrentAmount, bohPrice, bohCreatedTimestamp, bohTerminatedTimestamp, bohType, bohTerminatedReason, bohActive);
    }

    @Basic
    @Column(name = "boh_market")
    public String getBohMarket() {
        return bohMarket;
    }

    public void setBohMarket(String bohMarket) {
        this.bohMarket = bohMarket;
    }
}
