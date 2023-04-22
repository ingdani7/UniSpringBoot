package ingdani.com.co.servicio;

import ingdani.com.co.dao.PuntoDeVisitaDao;
import ingdani.com.co.domain.PuntoDeVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuntoDeVisitaServiceImplementacion implements PuntoDeVisitaService {
    @Autowired
    private PuntoDeVisitaDao puntoDeVisitaDao;

    @Override
    @Transactional(readOnly = true)
    public List<PuntoDeVisita> listarPuntoVisitas() {
        return (List<PuntoDeVisita>) puntoDeVisitaDao.findAll();
    }

    @Override
    @Transactional()
    public void guardarPuntoVisita(PuntoDeVisita puntoDeVisita) {
        puntoDeVisitaDao.save(puntoDeVisita);
    }

    @Override
    @Transactional()
    public void eliminar(PuntoDeVisita puntoDeVisita) {
        puntoDeVisitaDao.delete(puntoDeVisita);
    }

    @Override
    @Transactional(readOnly = true)
    public PuntoDeVisita encontrarPuntoVisita(PuntoDeVisita puntoDeVisita) {
        return puntoDeVisitaDao.findById(puntoDeVisita.getIdpunto_visita()).orElse(null);
    }
}
