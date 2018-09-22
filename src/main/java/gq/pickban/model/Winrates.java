package gq.pickban.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "winrates")
public class Winrates {
    @Id
    @GeneratedValue
    private long teamId;

    private BigDecimal cacheWinrate;

    @Column(name = "dust2_winrate")
    private BigDecimal dust2Winrate;

    private BigDecimal infernoWinrate;

    private BigDecimal mirageWinrate;

    private BigDecimal nukeWinrate;

    private BigDecimal overpassWinrate;

    private BigDecimal trainWinrate;

    private Date updateDate;

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public BigDecimal getCacheWinrate() {
        return cacheWinrate;
    }

    public void setCacheWinrate(BigDecimal cacheWinrate) {
        this.cacheWinrate = cacheWinrate;
    }

    public BigDecimal getDust2Winrate() {
        return dust2Winrate;
    }

    public void setDust2Winrate(BigDecimal dust2Winrate) {
        this.dust2Winrate = dust2Winrate;
    }

    public BigDecimal getInfernoWinrate() {
        return infernoWinrate;
    }

    public void setInfernoWinrate(BigDecimal infernoWinrate) {
        this.infernoWinrate = infernoWinrate;
    }

    public BigDecimal getMirageWinrate() {
        return mirageWinrate;
    }

    public void setMirageWinrate(BigDecimal mirageWinrate) {
        this.mirageWinrate = mirageWinrate;
    }

    public BigDecimal getNukeWinrate() {
        return nukeWinrate;
    }

    public void setNukeWinrate(BigDecimal nukeWinrate) {
        this.nukeWinrate = nukeWinrate;
    }

    public BigDecimal getOverpassWinrate() {
        return overpassWinrate;
    }

    public void setOverpassWinrate(BigDecimal overpassWinrate) {
        this.overpassWinrate = overpassWinrate;
    }

    public BigDecimal getTrainWinrate() {
        return trainWinrate;
    }

    public void setTrainWinrate(BigDecimal trainWinrate) {
        this.trainWinrate = trainWinrate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
