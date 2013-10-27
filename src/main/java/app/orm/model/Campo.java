package app.orm.model;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "campo")
public class Campo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "costo_hora")
    private Double costoHora;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_local")
    private Local local;

    @OneToMany(mappedBy = "campo", fetch = FetchType.LAZY)
    private List<SolicitudAlquiler> solicitudAlquiler;

    public Campo() {}

    public Campo(Long id) {
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

    public Integer getEstado() {
        return estado;
    }	

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipo() {
        return tipo;
    }	

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double getCostoHora() {
        return costoHora;
    }	

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    public List<SolicitudAlquiler> getSolicitudAlquiler() {
           return solicitudAlquiler;
    }

    public void setSolicitudAlquiler(List<SolicitudAlquiler> solicitudAlquiler) {
        this.solicitudAlquiler = solicitudAlquiler;
    }
}