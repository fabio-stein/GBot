package com.fabiolux.gbot.dao.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "braziliex_status", schema = "public", catalog = "gbot")
public class BraziliexStatus {
    private Integer bsId;
    private Timestamp bsLastCheck;

    @Id
    @Column(name = "bs_id", nullable = false)
    public Integer getBsId() {
        return bsId;
    }

    public void setBsId(Integer bsId) {
        this.bsId = bsId;
    }

    @Basic
    @Column(name = "bs_last_check", nullable = true)
    public Timestamp getBsLastCheck() {
        return bsLastCheck;
    }

    public void setBsLastCheck(Timestamp bsLastCheck) {
        this.bsLastCheck = bsLastCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BraziliexStatus that = (BraziliexStatus) o;
        return Objects.equals(bsId, that.bsId) &&
                Objects.equals(bsLastCheck, that.bsLastCheck);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bsId, bsLastCheck);
    }
}
