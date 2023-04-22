package ingdani.com.co.servicio;

import ingdani.com.co.dao.TourDao;
import ingdani.com.co.domain.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TourServiceImplementacion implements TourService {
    @Autowired
    private TourDao tourDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tour> listarToures() {
        return (List<Tour>) tourDao.findAll();
    }

    @Override
    @Transactional()
    public void guardarTour(Tour tour) {
        tourDao.save(tour);
    }

    @Override
    @Transactional()
    public void eliminar(Tour tour) {
        tourDao.delete(tour);
    }

    @Override
    @Transactional(readOnly = true)
    public Tour encontrarTour(Tour tour) {
        return tourDao.findById(tour.getId_tour()).orElse(null);
    }
}
