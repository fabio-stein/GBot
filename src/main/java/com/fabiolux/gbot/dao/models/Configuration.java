package com.fabiolux.gbot.dao.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Configuration{

    private Integer confId;
    private String confKey;

    @Id
    @Column(name = "conf_id", nullable = false)
    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
    }

    @Basic
    @Column(name = "conf_key", nullable = true, length = 20)
    public String getConfKey() {
        return confKey;
    }

    public void setConfKey(String confKey) {
        this.confKey = confKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(confId, that.confId) &&
                Objects.equals(confKey, that.confKey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(confId, confKey);
    }
}
