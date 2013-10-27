package app.orm.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "local")
public class Local implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "maps")
    private String maps;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "local", fetch = FetchType.LAZY)
   private List<Campo> campo;

    public Local() {}

    public Local(Long id) {
        this.id =id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }	

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getMaps() {
        return maps;
    }	

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getTelefono() {
        return telefono;
    }	

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Campo> getCampo() {
        return campo;
    }

    public void setCampo(List<Campo> campo) {
        this.campo = campo;
    }



    
    
}