package mode.repository;

import model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository <Contato, Integer>{

}
