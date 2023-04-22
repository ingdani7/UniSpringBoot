package ingdani.com.co.servicio;

import ingdani.com.co.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VendedorService {
    public List<Vendedor> listarVendedor();

    public void guardar(Vendedor vendedor);

    public void eliminar(Vendedor vendedor);

    public Vendedor encontrarVendedor(Vendedor vendedor);
}
