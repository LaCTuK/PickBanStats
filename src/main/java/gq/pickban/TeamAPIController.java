package gq.pickban;

import gq.pickban.model.Team;
import gq.pickban.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamAPIController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public Iterable findAll() {
        return teamRepository.findAll();
    }
    @GetMapping("/{id}")
    public Team findByID(@PathVariable long id) {
        return teamRepository.findById(id);
                //.orElseThrow(TeamNotFoundException::new);
    }

    @GetMapping("/name/{teamName}")
    public List findByNAME(@PathVariable String teamName) {
        return teamRepository.findByName(teamName);
    }
}
