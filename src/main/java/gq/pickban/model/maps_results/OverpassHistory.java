package gq.pickban.model.maps_results;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "overpass_history")
public class OverpassHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "opponent_name")
    private String opponentName;

    @Column(name = "winlose")
    private String winlose;

    @Column(name = "score")
    private String score;

    @Column(name = "game_date")
    private Date gameDate;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public String getWinlose() {
        return winlose;
    }

    public void setWinlose(String winlose) {
        this.winlose = winlose;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
}
