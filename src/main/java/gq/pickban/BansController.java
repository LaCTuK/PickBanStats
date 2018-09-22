package gq.pickban;

import com.fasterxml.jackson.databind.ObjectMapper;
import gq.pickban.model.*;
import gq.pickban.model.maps_results.*;
import gq.pickban.repository.*;
import gq.pickban.repository.maps_results.*;
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
    @Autowired
    private CacheHistoryRepository cacheHistoryRepository;
    @Autowired
    private Dust2HistoryRepository dust2HistoryRepository;
    @Autowired
    private InfernoHistoryRepository infernoHistoryRepository;
    @Autowired
    private MirageHistoryRepository mirageHistoryRepository;
    @Autowired
    private NukeHistoryRepository nukeHistoryRepository;
    @Autowired
    private OverpassHistoryRepository overpassHistoryRepository;
    @Autowired
    private TrainHistoryRepository trainHistoryRepository;

    @Autowired
    private WinratesRepository winratesRepository;

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

        List <List <CacheHistory>> listOfCacheH = new ArrayList<>();
        List<CacheHistory> cache1 = cacheHistoryRepository.findByTeamId(id1);
        listOfCacheH.add(cache1);
        List<CacheHistory> cache2 = cacheHistoryRepository.findByTeamId(id2);
        listOfCacheH.add(cache2);

        List <List <Dust2History>> listOfDust2H = new ArrayList<>();
        List<Dust2History> dust21 = dust2HistoryRepository.findByTeamId(id1);
        listOfDust2H.add(dust21);
        List<Dust2History> dust22 = dust2HistoryRepository.findByTeamId(id2);
        listOfDust2H.add(dust22);

        List <List <InfernoHistory>> listOfInfernoH = new ArrayList<>();
        List<InfernoHistory> inferno1 = infernoHistoryRepository.findByTeamId(id1);
        listOfInfernoH.add(inferno1);
        List<InfernoHistory> inferno2 = infernoHistoryRepository.findByTeamId(id2);
        listOfInfernoH.add(inferno2);

        List <List <MirageHistory>> listOfMirageH = new ArrayList<>();
        List<MirageHistory> mirage1 = mirageHistoryRepository.findByTeamId(id1);
        listOfMirageH.add(mirage1);
        List<MirageHistory> mirage2 = mirageHistoryRepository.findByTeamId(id2);
        listOfMirageH.add(mirage2);

        List <List <NukeHistory>> listOfNukeH = new ArrayList<>();
        List<NukeHistory> nuke1 = nukeHistoryRepository.findByTeamId(id1);
        listOfNukeH.add(nuke1);
        List<NukeHistory> nuke2 = nukeHistoryRepository.findByTeamId(id2);
        listOfNukeH.add(nuke2);

        List <List <OverpassHistory>> listOfOverpassH = new ArrayList<>();
        List<OverpassHistory> overpass1 = overpassHistoryRepository.findByTeamId(id1);
        listOfOverpassH.add(overpass1);
        List<OverpassHistory> overpass2 = overpassHistoryRepository.findByTeamId(id2);
        listOfOverpassH.add(overpass2);

        List <List <TrainHistory>> listOfTrainH = new ArrayList<>();
        List<TrainHistory> train1 = trainHistoryRepository.findByTeamId(id1);
        listOfTrainH.add(train1);
        List<TrainHistory> train2 = trainHistoryRepository.findByTeamId(id2);
        listOfTrainH.add(train2);


        List <Winrates> listOfWinrates = new ArrayList<>();
        Winrates winrates1 = winratesRepository.findByTeamId(id1);
        listOfWinrates.add(winrates1);
        Winrates winrates2 = winratesRepository.findByTeamId(id2);
        listOfWinrates.add(winrates2);



        model.addAttribute("bans", listOfBans);
        model.addAttribute("picks", listOfPicks);
        model.addAttribute("lefts", listOfLeft);
        model.addAttribute("cache", listOfCacheH);
        model.addAttribute("dust2", listOfDust2H);
        model.addAttribute("inferno", listOfInfernoH);
        model.addAttribute("mirage", listOfMirageH);
        model.addAttribute("nuke", listOfNukeH);
        model.addAttribute("overpass", listOfOverpassH);
        model.addAttribute("train", listOfTrainH);
        model.addAttribute("winrates", listOfWinrates);

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
