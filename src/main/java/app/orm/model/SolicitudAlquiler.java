package app.orm.model;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "solicitud_alquiler")
public class SolicitudAlquiler implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private  String horaFin;

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "servicios")
    private String servicios;

    @Column(name = "estado")
    private Integer estado;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_socio")
    private Socio socio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_campo")
    private Campo campo;

    public SolicitudAlquiler() {}

    public SolicitudAlquiler(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }	

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getServicios() {
        return servicios;
    }	

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public Integer getEstado() {
        return estado;
    }	

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }
}