package ingdani.com.co.servicio;

import ingdani.com.co.domain.Compra;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompraService {

    public List<Compra> listarCompra();

    public void guardar(Compra compra);

    public void eliminar(Compra compra);

    public Compra encontrarCompra(Compra compra);
}
