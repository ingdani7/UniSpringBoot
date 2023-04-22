package ingdani.com.co.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "punto_visita")
public class PuntoDeVisita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpunto_visita;
    private String actividad;
    private String departamento;
    private String ciudad;
}
