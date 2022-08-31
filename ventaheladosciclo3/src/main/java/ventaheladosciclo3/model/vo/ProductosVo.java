package ventaheladosciclo3.model.vo;

public class ProductosVo {
    private int id;
    private int cod;
    private String descripcion;
    private double precioAdmin;
    private double precioVendedor;
    private double precioPublico;

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

}
