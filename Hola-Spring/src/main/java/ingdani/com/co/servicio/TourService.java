package ingdani.com.co.servicio;

import ingdani.com.co.domain.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {
    public List<Tour> listarToures();

    public void guardarTour(Tour tour);

    public void eliminar(Tour tour);

    public Tour encontrarTour(Tour tour);
}
