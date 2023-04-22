package ingdani.com.co.web;

import ingdani.com.co.domain.*;
import ingdani.com.co.servicio.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class ControladorInicio {
    @Autowired
    private TourService tourService;
    @Autowired
    private PuntoDeVisitaService puntoDeVisitaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private CompraService compraService;


    /*CRUD DE CLIENTES*/

    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "/clientes";
    }

    @GetMapping("/agregar_cliente")
    public String agregar(Cliente cliente) {
        return "modificar";
    }

    @PostMapping("/guardar_cliente")
    public String guardar(@Valid Cliente cliente, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id_cliente}")
    public String editar(Cliente cliente, Model model) {
        cliente = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }

    @GetMapping("/eliminar/{id_cliente}")
    public String eliminar(Cliente cliente) {
        clienteService.eliminar(cliente);
        return "redirect:/clientes";
    }


    /*CRUD DE PUNTOS DE VISITA*/
    @GetMapping("/puntos_visita")
    public String mostrarPuntosVisita(Model model) {
        var puntoVisitas = puntoDeVisitaService.listarPuntoVisitas();
        model.addAttribute("puntoVisitas", puntoVisitas);
        return "puntos_visita";
    }

    @GetMapping("/new_puntov")
    public String nuevoPuntoV(PuntoDeVisita puntoDeVisita) {
        return "new_puntov";
    }

    @PostMapping("/guardar_pv")
    public String guardar_PuntoVisita(@Valid PuntoDeVisita puntoDeVisita, Errors errors) {
        if (errors.hasErrors()) {
            return "new_puntov";
        }
        puntoDeVisitaService.guardarPuntoVisita(puntoDeVisita);
        return "redirect:/puntos_visita";
    }

    @GetMapping("/editar_pv/{idpunto_visita}")
    public String editar_pv(PuntoDeVisita puntoDeVisita, Model model) {
        puntoDeVisita = puntoDeVisitaService.encontrarPuntoVisita(puntoDeVisita);
        model.addAttribute("puntoDeVisita", puntoDeVisita);
        return "new_puntov";
    }

    @GetMapping("eliminar_pv/{idpunto_visita}")
    public String eliminar_pv(PuntoDeVisita puntoDeVisita) {
        puntoDeVisitaService.eliminar(puntoDeVisita);
        return "redirect:/puntos_visita";
    }


    /*CRUD DE TOURS*/
    @GetMapping("/total_tour")
    public String toures_completos(Model model) {
        var toures = tourService.listarToures();
        model.addAttribute("toures", toures);
        return "total_tour";
    }

    @GetMapping("/new_tour")
    public String registro_turistico(Tour tour) {
        return "new_tour";
    }

    @PostMapping("/guardar_tour")
    public String guardarTour(@Valid Tour tour, Errors errors) {
        if (errors.hasErrors()) {
            return "new_tour";
        }
        tourService.guardarTour(tour);
        return "redirect:/total_tour";
    }

    @GetMapping("/editar_tour/{id_tour}")
    public String editar_tour(Tour tour, Model model) {
        tour = tourService.encontrarTour(tour);
        model.addAttribute("tour", tour);
        return "new_tour";
    }

    @GetMapping("eliminar_tour/{id_tour}")
    public String eliminar_tour(Tour tour) {
        tourService.eliminar(tour);
        return "redirect:/total_tour";
    }


    /*CRUD DE VENDEDORES*/
    @GetMapping("/vendedores")
    public String vendedores(Model model) {
        var vendedores = vendedorService.listarVendedor();
        model.addAttribute("vendedores", vendedores);
        return "vendedores";
    }

    @GetMapping("/new_vendedor")
    public String registro_vendedor(Vendedor vendedor) {
        return "new_vendedor";
    }

    @PostMapping("/guardar_vendedor")
    public String guardarVendedor(@Valid Vendedor vendedor, Errors errors) {
        if (errors.hasErrors()) {
            return "new_vendedor";
        }
        vendedorService.guardar(vendedor);
        return "redirect:/vendedores";
    }

    @GetMapping("/editar_vendedor/{id_vendedor}")
    public String editar_vendedor(Vendedor vendedor, Model model) {
        vendedor = vendedorService.encontrarVendedor(vendedor);
        model.addAttribute("vendedor", vendedor);
        return "new_vendedor";
    }

    @GetMapping("eliminar_vendedor/{id_vendedor}")
    public String eliminar_vendedor(Vendedor vendedor) {
        vendedorService.eliminar(vendedor);
        return "redirect:/vendedores";
    }



    /*CRUD DE COMPRAS*/


    @GetMapping("/compras")
    public String compras(Model model) {
        var compras = compraService.listarCompra();
        model.addAttribute("compras", compras);
        return "compras";
    }

    @GetMapping("/new_compra")
    public String registro_compra(Compra compra) {
        return "new_compra";
    }

    @PostMapping("/guardar_compra")
    public String guardarCompra(@Valid Compra compra, Errors errors) {
        if (errors.hasErrors()) {
            return "new_compra";
        }
        compraService.guardar(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editar_compra/{id_compra}")
    public String editar_compra(Compra compra, Model model) {
        compra = compraService.encontrarCompra(compra);
        model.addAttribute("compra", compra);
        return "new_compra";
    }

    @GetMapping("eliminar_compra/{id_compra}")
    public String eliminar_compra(Compra compra) {
        compraService.eliminar(compra);
        return "redirect:/compras";
    }

}