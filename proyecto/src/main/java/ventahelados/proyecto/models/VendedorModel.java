package ventahelados.proyecto.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vendedores")
public class VendedorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(name = "cedula_ciudadania", unique = true, nullable = false)
    private Integer cc;
    @Column(name = "primer_nombre", nullable = false, length = 15)
    private String nombre1;
    @Column(name = "segundo_nombre", nullable = false, length = 15)
    private String nombre2;
    @Column(name = "primer_apellido", nullable = false, length = 15)
    private String apellido1;
    @Column(name = "segundo_apellido", nullable = false, length = 15)
    private String apellido2;
    @Column(name = "fecha_nacimiento", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date cumpleAnios;
    @Column(name = "telefono", nullable = false)
    private long telefono;
    @Column(name = "estado_vendedor", nullable = false, length = 10)
    private String estado;
    @OneToMany(mappedBy = "vendedor")
    Set<VentaModel> ventas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getCumpleAnios() {
        return cumpleAnios;
    }

    public void setCumpleAnios(Date cumpleAnios) {
        this.cumpleAnios = cumpleAnios;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
