package ingdani.com.co.servicio;

import ingdani.com.co.dao.PersonaDao;
import ingdani.com.co.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImplementation implements PersonaService {
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
        /*
         * finfAll retorna un tipo Object, hacemos un CAST
         * Para convertirlo en una lista
         * **/
    }

    @Override
    @Transactional()
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional()
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getId_persona()).orElse(null);
        /*
         * findById retorna un tipo Optional, hacemos una condicion orElse
         * Para manipular el retorno en caso de ser un null
         * **/
    }
}
