package ingdani.com.co.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tour")
public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tour;

    private Date fecha;
    private String descripcion;
    private Integer tiempo_duracion;
    private Boolean desayunos;
    private Boolean almuerzos;
    private Float costo;
    private String estado;

    @OneToMany
    @JoinColumn(name="id_tour")
    private List<PuntoDeVisita> puntoDeVisitas;
}
