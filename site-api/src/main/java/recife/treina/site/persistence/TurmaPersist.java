package recife.treina.site.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recife.treina.site.model.Turma;

@Repository
public interface TurmaPersist extends JpaRepository <Turma, Long> {


}