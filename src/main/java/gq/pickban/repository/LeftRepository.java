package gq.pickban.repository;

import gq.pickban.model.Left;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeftRepository extends CrudRepository<Left, Long> {
    List<Left> findAll();
    Left findById(long id);
}
