package recife.treina.site.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recife.treina.site.model.Usuario;

@Repository
public interface CursoPersist extends JpaRepository <Usuario, Long> { 

  
}