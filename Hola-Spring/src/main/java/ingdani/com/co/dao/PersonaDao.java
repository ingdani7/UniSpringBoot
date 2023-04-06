package ingdani.com.co.dao;

import ingdani.com.co.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository <Persona, Long> {
}
