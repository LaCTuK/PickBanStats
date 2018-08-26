package gq.pickban.repository;


import gq.pickban.model.VisitStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitStatsRepository extends CrudRepository<VisitStats, Long> {
    List<VisitStats> findAllByOrderByIdDesc();

    List<VisitStats> findByTimeAfter(Date date);
}
