package ingdani.com.co.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombre;
    private String cedula;
    private Date cumpleanos;
    private String telefono;
    private String celular;
    private String correo;
    private String contacto_emergencia;
    private String telefono_emergencia;

}
