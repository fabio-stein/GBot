package com.fabiolux.gbot.dao.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_orderbook_change", schema = "public", catalog = "gbot")
public class BraziliexOrderbookChange {
    private Long bocId;
    private BigInteger bocPreviousAmount;
    private BigInteger bocNewAmount;
    private Timestamp bocTimestamp;
    private Integer bocType;

    @Id
    @Column(name = "boc_id", nullable = false)
    public Long getBocId() {
        return bocId;
    }

    public void setBocId(Long bocId) {
        this.bocId = bocId;
    }

    @Basic
    @Column(name = "boc_previous_amount", nullable = false, precision = 0)
    public BigInteger getBocPreviousAmount() {
        return bocPreviousAmount;
    }

    public void setBocPreviousAmount(BigInteger bocPreviousAmount) {
        this.bocPreviousAmount = bocPreviousAmount;
    }

    @Basic
    @Column(name = "boc_new_amount", nullable = false, precision = 0)
    public BigInteger getBocNewAmount() {
        return bocNewAmount;
    }

    public void setBocNewAmount(BigInteger bocNewAmount) {
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
}
