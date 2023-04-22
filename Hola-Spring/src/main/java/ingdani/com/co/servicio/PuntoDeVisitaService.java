package ingdani.com.co.servicio;

import ingdani.com.co.domain.PuntoDeVisita;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PuntoDeVisitaService {
    public List<PuntoDeVisita> listarPuntoVisitas();

    public void guardarPuntoVisita(PuntoDeVisita puntoDeVisita);

    public void eliminar(PuntoDeVisita puntoDeVisita);

    public PuntoDeVisita encontrarPuntoVisita(PuntoDeVisita puntoDeVisita);
}
