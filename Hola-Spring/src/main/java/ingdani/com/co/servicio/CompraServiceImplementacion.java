package ingdani.com.co.servicio;

import ingdani.com.co.dao.CompraDao;
import ingdani.com.co.domain.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompraServiceImplementacion implements CompraService {
    @Autowired
    private CompraDao compraDao;

    @Override
    public List<Compra> listarCompra() {
        return (List<Compra>) compraDao.findAll();
    }

    @Override
    public void guardar(Compra compra) {
        compraDao.save(compra);
    }

    @Override
    public void eliminar(Compra compra) {
        compraDao.delete(compra);
    }

    @Override
    public Compra encontrarCompra(Compra compra) {
        return compraDao.findById(compra.getId_compra()).orElse(null);
    }
}
