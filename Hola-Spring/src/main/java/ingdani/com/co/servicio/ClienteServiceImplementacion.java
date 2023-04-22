package ingdani.com.co.servicio;

import ingdani.com.co.dao.ClienteDao;
import ingdani.com.co.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplementacion implements ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void guardar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente encontrarCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getId_cliente()).orElse(null);

    }
}
