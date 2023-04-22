package ingdani.com.co.servicio;

import ingdani.com.co.dao.VendedorDao;
import ingdani.com.co.domain.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorServiceImplementation implements VendedorService {
    @Autowired
    private VendedorDao vendedorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vendedor> listarVendedor() {
        return (List<Vendedor>) vendedorDao.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Vendedor vendedor) {
        vendedorDao.save(vendedor);
    }

    @Override
    @Transactional()
    public void eliminar(Vendedor vendedor) {
        vendedorDao.delete(vendedor);
    }

    @Override
    @Transactional
    public Vendedor encontrarVendedor(Vendedor vendedor) {
        return vendedorDao.findById(vendedor.getId_vendedor()).orElse(null);
        /*
         * findById retorna un tipo Optional, hacemos una condicion orElse
         * Para manipular el retorno en caso de ser un null
         * **/
    }
}
