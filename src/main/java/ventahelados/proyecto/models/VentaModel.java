package ventahelados.proyecto.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ventas")
public class VentaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "cod_producto")
    ProductoModel producto;
    @ManyToOne
    @JoinColumn(name = "cedula_ciudadania")
    VendedorModel vendedor;
    @Column(name = "fecha_hora_venta", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraVenta;
    @Column(name = "cantidad_entrega", unique = true, nullable = false)
    private Integer cantidadEntrega;
    @Column(name = "cantidad_recibe", unique = true, nullable = false)
    private Integer cantidadRecibe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public Integer getCantidadEntrega() {
        return cantidadEntrega;
    }

    public void setCantidadEntrega(Integer cantidadEntrega) {
        this.cantidadEntrega = cantidadEntrega;
    }

    public Integer getCantidadRecibe() {
        return cantidadRecibe;
    }

    public void setCantidadRecibe(Integer cantidadRecibe) {
        this.cantidadRecibe = cantidadRecibe;
    }

}
