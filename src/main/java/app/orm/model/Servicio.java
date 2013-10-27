package app.orm.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo_hora")
    private Double costoHora;

    public Servicio() {}

    public Servicio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }	

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoHora() {
        return costoHora;
    }	

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }

}