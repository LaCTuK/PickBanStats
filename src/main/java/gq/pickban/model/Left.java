package gq.pickban.model;

import javax.persistence.*;

@Entity
@Table(name = "left_view")
public class Left {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer cbl;

    private Integer trn;

    private Integer nuke;

    private Integer mrg;

    private Integer inf;

    private Integer cch;

    private Integer ovp;

    private Integer d2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCbl() {
        return cbl;
    }

    public void setCbl(Integer cbl) {
        this.cbl = cbl;
    }

    public Integer getTrn() {
        return trn;
    }

    public void setTrn(Integer trn) {
        this.trn = trn;
    }

    public Integer getNuke() {
        return nuke;
    }

    public void setNuke(Integer nuke) {
        this.nuke = nuke;
    }

    public Integer getMrg() {
        return mrg;
    }

    public void setMrg(Integer mrg) {
        this.mrg = mrg;
    }

    public Integer getInf() {
        return inf;
    }

    public void setInf(Integer inf) {
        this.inf = inf;
    }

    public Integer getCch() {
        return cch;
    }

    public void setCch(Integer cch) {
        this.cch = cch;
    }

    public Integer getOvp() {
        return ovp;
    }

    public void setOvp(Integer ovp) {
        this.ovp = ovp;
    }

    public Integer getD2() {
        return d2;
    }

    public void setD2(Integer d2) {
        this.d2 = d2;
    }
}
