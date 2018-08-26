package gq.pickban;

import gq.pickban.model.Interesting;
import gq.pickban.model.Team;
import gq.pickban.model.Updates;
import gq.pickban.model.VisitStats;
import gq.pickban.repository.InterestingRepository;
import gq.pickban.repository.TeamRepository;
import gq.pickban.repository.UpdatesRepository;
import gq.pickban.repository.VisitStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller    // This means that this class is a Controller
public class MainController {
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UpdatesRepository updatesRepository;

	@Autowired
	private InterestingRepository interestingRepository;

	final VisitStatsRepository visitStatsRepository;

	public MainController(VisitStatsRepository visitStatsRepository) {
		this.visitStatsRepository = visitStatsRepository;
	}

	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/")
	public String homePage(Model model, HttpServletRequest request) {

		List<Team> listOfTeams;
		listOfTeams = (List<Team>) teamRepository.findAll();
		Collections.sort(listOfTeams, Comparator.comparing(p -> p.getName().toUpperCase()));

		List<Updates> listOfUpdates;
		listOfUpdates = (List<Updates>) updatesRepository.findAll();

		List<Interesting> listOfInteresting;
		listOfInteresting = (List<Interesting>) interestingRepository.findAll();

		saveStat(request);

		model.addAttribute("teams", listOfTeams);
		model.addAttribute("updates", listOfUpdates);
		model.addAttribute("interesting", listOfInteresting);
		model.addAttribute("appName", appName);
		return "home";
	}

	@GetMapping("/soon")
	public String soonPage(HttpServletRequest request) {
		saveStat(request);
		return "soon";
	}

	@GetMapping("/feedback")
	public String feedbackPage(HttpServletRequest request) {
		saveStat(request);
		return "feedback";
	}

	@GetMapping("/about")
	public String aboutPage(HttpServletRequest request) {
		saveStat(request);
		return "about";
	}

	@GetMapping("/donations")
	public String donationsPage(HttpServletRequest request) {
		saveStat(request);
		return "donations";
	}

	private void saveStat(HttpServletRequest req) {
		VisitStats visit = new VisitStats();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		visit.setTime(timestamp);
		String url = String.valueOf(req.getRequestURL());
		visit.setLink(url);
		String ip = req.getRemoteAddr();
		visit.setIp(ip);
		visitStatsRepository.save(visit);
	}
}
