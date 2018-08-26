package gq.pickban;

import com.fasterxml.jackson.databind.ObjectMapper;
import gq.pickban.model.Bans;
import gq.pickban.model.Left;
import gq.pickban.model.Picks;
import gq.pickban.model.VisitStats;
import gq.pickban.repository.BansRepository;
import gq.pickban.repository.LeftRepository;
import gq.pickban.repository.PicksRepository;
import gq.pickban.repository.VisitStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BansController {

    @Autowired
    private BansRepository bansRepository;
    @Autowired
    private PicksRepository picksRepository;
    @Autowired
    private LeftRepository leftRepository;

    final VisitStatsRepository visitStatsRepository;

    public BansController(VisitStatsRepository visitStatsRepository) {
        this.visitStatsRepository = visitStatsRepository;
    }

    @GetMapping("/bans")
    public String banPage(Model model, HttpServletRequest request) {
        List<Bans> listOfBans;
        listOfBans = (List<Bans>) bansRepository.findAll();
        List<Picks> listOfPicks;
        listOfPicks = (List<Picks>) picksRepository.findAll();
        List<Left> listOfLeft;
        listOfLeft = (List<Left>) leftRepository.findAll();
        model.addAttribute("bans", listOfBans);
        model.addAttribute("picks", listOfPicks);
        model.addAttribute("lefts", listOfLeft);
        saveStat(request, "bans main");
        return "bans";
    }

    @GetMapping("/bans/{id1}/{id2}")
    public String findByIds(@PathVariable long id1,@PathVariable long id2, Model model, HttpServletRequest request) {

        ObjectMapper objectMapper = new ObjectMapper();


        List <Bans> listOfBans = new ArrayList<>();
        Bans ban1 = bansRepository.findById(id1);
        listOfBans.add(ban1);
        Bans ban2 = bansRepository.findById(id2);
        listOfBans.add(ban2);

        List <Picks> listOfPicks = new ArrayList<>();
        Picks pick1 = picksRepository.findById(id1);
        listOfPicks.add(pick1);
        Picks pick2 = picksRepository.findById(id2);
        listOfPicks.add(pick2);

        List <Left> listOfLeft = new ArrayList<>();
        Left left1 = leftRepository.findById(id1);
        listOfLeft.add(left1);
        Left left2 = leftRepository.findById(id2);
        listOfLeft.add(left2);

        model.addAttribute("bans", listOfBans);
        model.addAttribute("picks", listOfPicks);
        model.addAttribute("lefts", listOfLeft);

        String teamNames = ban1.getName() + " " + ban2.getName();
        saveStat(request, teamNames);
        return "bans";
        //.orElseThrow(TeamNotFoundException::new);
    }

    @GetMapping("/bans/{id}")
    public String findByIds(@PathVariable long id, Model model, HttpServletRequest request) {
        List <Bans> listOfBans = new ArrayList<>();
        Bans ban1 = bansRepository.findById(id);
        listOfBans.add(ban1);

        List <Picks> listOfPicks = new ArrayList<>();
        Picks pick1 = picksRepository.findById(id);
        listOfPicks.add(pick1);

        List <Left> listOfLeft = new ArrayList<>();
        Left left1 = leftRepository.findById(id);
        listOfLeft.add(left1);

        model.addAttribute("bans", listOfBans);
        model.addAttribute("picks", listOfPicks);
        model.addAttribute("lefts", listOfLeft);

        String teamName = ban1.getName();
        saveStat(request, teamName);
        return "bans";
        //.orElseThrow(TeamNotFoundException::new);
    }

    private void saveStat(HttpServletRequest req, String text) {
        VisitStats visit = new VisitStats();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        visit.setTime(timestamp);
        String url = String.valueOf(req.getRequestURL()) + " " + text;
        visit.setLink(url);
        String ip = req.getRemoteAddr();
        visit.setIp(ip);
        visitStatsRepository.save(visit);
    }
}
