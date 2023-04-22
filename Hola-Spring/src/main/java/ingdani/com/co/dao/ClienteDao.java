package ingdani.com.co.dao;

import ingdani.com.co.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
}
