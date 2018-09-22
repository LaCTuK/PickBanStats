package gq.pickban.repository;


import gq.pickban.model.Winrates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinratesRepository extends CrudRepository<Winrates, Long> {
    Winrates findByTeamId(long id);
    List<Winrates> findAll();
}
