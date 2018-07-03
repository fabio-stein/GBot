package com.fabiolux.gbot.dao.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_orderbook_change", schema = "public", catalog = "gbot")
public class BraziliexOrderbookChange {
    private Long bocId;
    private BigDecimal bocPreviousAmount;
    private BigDecimal bocNewAmount;
    private Timestamp bocTimestamp;
    private Integer bocType;
    private Long bocOrderItem;
    private Long bocTradeHistoryReference;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boc_id", nullable = false)
    public Long getBocId() {
        return bocId;
    }

    public void setBocId(Long bocId) {
        this.bocId = bocId;
    }

    @Basic
    @Column(name = "boc_previous_amount", nullable = false, precision = 0)
    public BigDecimal getBocPreviousAmount() {
        return bocPreviousAmount;
    }

    public void setBocPreviousAmount(BigDecimal bocPreviousAmount) {
        this.bocPreviousAmount = bocPreviousAmount;
    }

    @Basic
    @Column(name = "boc_new_amount", nullable = false, precision = 0)
    public BigDecimal getBocNewAmount() {
        return bocNewAmount;
    }

    public void setBocNewAmount(BigDecimal bocNewAmount) {
        this.bocNewAmount = bocNewAmount;
    }

    @Basic
    @Column(name = "boc_timestamp", nullable = false)
    public Timestamp getBocTimestamp() {
        return bocTimestamp;
    }

    public void setBocTimestamp(Timestamp bocTimestamp) {
        this.bocTimestamp = bocTimestamp;
    }

    @Basic
    @Column(name = "boc_type", nullable = false)
    public Integer getBocType() {
        return bocType;
    }

    public void setBocType(Integer bocType) {
        this.bocType = bocType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BraziliexOrderbookChange that = (BraziliexOrderbookChange) o;
        return Objects.equals(bocId, that.bocId) &&
                Objects.equals(bocPreviousAmount, that.bocPreviousAmount) &&
                Objects.equals(bocNewAmount, that.bocNewAmount) &&
                Objects.equals(bocTimestamp, that.bocTimestamp) &&
                Objects.equals(bocType, that.bocType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bocId, bocPreviousAmount, bocNewAmount, bocTimestamp, bocType);
    }

    @Basic
    @Column(name = "boc_order_item", nullable = false)
    public Long getBocOrderItem() {
        return bocOrderItem;
    }

    public void setBocOrderItem(Long bocOrderItem) {
        this.bocOrderItem = bocOrderItem;
    }

    @Basic
    @Column(name = "boc_trade_history_reference", nullable = true)
    public Long getBocTradeHistoryReference() {
        return bocTradeHistoryReference;
    }

    public void setBocTradeHistoryReference(Long bocTradeHistoryReference) {
        this.bocTradeHistoryReference = bocTradeHistoryReference;
    }
}
