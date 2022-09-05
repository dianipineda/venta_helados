package ventaheladosciclo3.model.vo;

public class ProductosVo {
    // Atributos:
    private int id;
    private int cod;
    private String descripcion;
    private double precioAdmin;
    private double precioVendedor;
    private double precioPublico;
    private String estado;

    // Constructores:
    public ProductosVo(int cod, String descripcion, double precioAdmin, double precioVendedor, double precioPublico) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precioAdmin = precioAdmin;
        this.precioVendedor = precioVendedor;
        this.precioPublico = precioPublico;

    }

    public ProductosVo(int cod) {
        this.cod = cod;
    }

    // Métodos:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioAdmin() {
        return precioAdmin;
    }

    public void setPrecioAdmin(double precioAdmin) {
        this.precioAdmin = precioAdmin;
    }

    public double getPrecioVendedor() {
        return precioVendedor;
    }

    public void setPrecioVendedor(double precioVendedor) {
        this.precioVendedor = precioVendedor;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\t" + cod + " " + descripcion + " " + precioAdmin + " " + precioVendedor
                + " " + precioPublico + "\n";
    }

}
