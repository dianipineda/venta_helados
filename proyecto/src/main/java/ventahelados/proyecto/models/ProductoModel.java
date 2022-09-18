package ventahelados.proyecto.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(name = "cod_producto", unique = true, nullable = false)
    private Integer codigo;
    @Column(name = "descripcion_producto", nullable = false, length = 25)
    private String descripcion;
    @Column(name = "precio_admin", nullable = false, scale = 1)
    private Double pAdmin;
    @Column(name = "precio_vendedor", nullable = false, scale = 1)
    private Double pVendedor;
    @Column(name = "precio_publico", nullable = false, scale = 1)
    private Double pPublico;
    @Column(name = "estado_producto", nullable = false, columnDefinition = "varchar(15) default 'activo'")
    private String estado;
    @OneToMany(mappedBy = "producto")
    Set<VentaModel> ventas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getpAdmin() {
        return pAdmin;
    }

    public void setpAdmin(Double pAdmin) {
        this.pAdmin = pAdmin;
    }

    public Double getpVendedor() {
        return pVendedor;
    }

    public void setpVendedor(Double pVendedor) {
        this.pVendedor = pVendedor;
    }

    public Double getpPublico() {
        return pPublico;
    }

    public void setpPublico(Double pPublico) {
        this.pPublico = pPublico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
