package gq.pickban;

import gq.pickban.model.VisitStats;
import gq.pickban.repository.VisitStatsRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StatsController {

    @Autowired
    VisitStatsRepository visitStatsRepository;

    @GetMapping("/stats")
    public String statsPage(Model model) {

        List<VisitStats> visits = (List<VisitStats>) visitStatsRepository.findAllByOrderByIdDesc();

        DateTime todayStartDate = new DateTime().withTimeAtStartOfDay();
        System.out.println(todayStartDate);
        System.out.println(todayStartDate.toDate());

        DateTime dateTime = new DateTime().minusHours(1);
        System.out.println(dateTime);
        System.out.println(dateTime.toDate());

        List<VisitStats> visitsToday = (List<VisitStats>) visitStatsRepository.findByTimeAfter(todayStartDate.toDate());
        List<VisitStats> visitsHour = (List<VisitStats>) visitStatsRepository.findByTimeAfter(dateTime.toDate());

        model.addAttribute("stats", visits);
        model.addAttribute("visitsToday", visitsToday);
        model.addAttribute("visitsHour", visitsHour);

        return "stats";
    }
}
