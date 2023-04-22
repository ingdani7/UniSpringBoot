package ingdani.com.co.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
//CREAMOS LA CLASE Persona como una entidad donde obtenemos la informacion de la BD
@Data
@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {
    private  static final long   serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vendedor;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String correo;
    private String celular;
}
