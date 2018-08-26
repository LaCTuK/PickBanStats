package gq.pickban.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "today_interesting")
public class Interesting {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name="team_id_1")
    private Long team1;

    @Column(name="team_id_2")
    private Long team2;

    @Column(name="hltv_link")
    private String HLTVLink;

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

    public Long getTeam1() {
        return team1;
    }

    public void setTeam1(Long team1) {
        this.team1 = team1;
    }

    public Long getTeam2() {
        return team2;
    }

    public void setTeam2(Long team2) {
        this.team2 = team2;
    }

    public String getHLTVLink() {
        return HLTVLink;
    }

    public void setHLTVLink(String HLTVLink) {
        this.HLTVLink = HLTVLink;
    }
}

