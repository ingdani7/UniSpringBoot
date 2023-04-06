package ingdani.com.co.web;

import ingdani.com.co.domain.Persona;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ingdani.com.co.servicio.PersonaService;

@Controller
@RequestMapping
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio (Model model) {
        var personas = personaService.listarPersonas();
        log.info("Ejecutanto el controlador SPRING MVC");
        model.addAttribute("personas",personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar (Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar (@Valid Persona persona, Errors errores){
        if (errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_persona}")
    public String editar (Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{id_persona}")
    public String eliminar (Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }



    /*
    //[PRIMEROS EJEMPLOS Y DATOS ESTATICOS]
    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola mundo con thymeleaf cambio";

        var persona = new Persona();
        persona.setName("Daniel");
        persona.setLastname("Perez");
        persona.setEmail("ingdani7@gmail.com");
        persona.setPhone("3152697778");

        var persona2 = new Persona();
        persona2.setName("juan");
        persona2.setLastname("londono");
        persona2.setEmail("juanlondo@gmail.com");
        persona2.setPhone("3124543454");

        //var personas = Arrays.asList(persona,persona2);
        List<Persona> personas = Arrays.asList(persona, persona2);
        //var personas = new ArrayList<>(); ArrayVacio

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        return "index";


    }**/
}
