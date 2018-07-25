package com.fabiolux.gbot.dao.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Configuration {
    private Integer confId;
    private String confApiBraziliex;
    private String confApiBraziliexSecret;
    private Long confBraziliexNonce;

    @Id
    @Column(name = "conf_id", nullable = false)
    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
    }

    @Basic
    @Column(name = "conf_api_braziliex", nullable = true, length = 255)
    public String getConfApiBraziliex() {
        return confApiBraziliex;
    }

    public void setConfApiBraziliex(String confApiBraziliex) {
        this.confApiBraziliex = confApiBraziliex;
    }

    @Basic
    @Column(name = "conf_api_braziliex_secret", nullable = true, length = 255)
    public String getConfApiBraziliexSecret() {
        return confApiBraziliexSecret;
    }

    public void setConfApiBraziliexSecret(String confApiBraziliexSecret) {
        this.confApiBraziliexSecret = confApiBraziliexSecret;
    }

    @Basic
    @Column(name = "conf_braziliex_nonce", nullable = true)
    public Long getConfBraziliexNonce() {
        return confBraziliexNonce;
    }

    public void setConfBraziliexNonce(Long confBraziliexNonce) {
        this.confBraziliexNonce = confBraziliexNonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(confId, that.confId) &&
                Objects.equals(confApiBraziliex, that.confApiBraziliex) &&
                Objects.equals(confApiBraziliexSecret, that.confApiBraziliexSecret) &&
                Objects.equals(confBraziliexNonce, that.confBraziliexNonce);
    }

    @Override
    public int hashCode() {

        return Objects.hash(confId, confApiBraziliex, confApiBraziliexSecret, confBraziliexNonce);
    }
}
