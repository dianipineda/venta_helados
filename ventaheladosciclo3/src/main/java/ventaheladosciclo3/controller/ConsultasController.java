package ventaheladosciclo3.controller;

import java.sql.SQLException;
import java.util.List;

import ventaheladosciclo3.model.dao.ProductosDao;
import ventaheladosciclo3.model.dao.VendedoresDao;
import ventaheladosciclo3.model.vo.ProductosVo;
import ventaheladosciclo3.model.vo.VendedoresVo;

public class ConsultasController {
    private ProductosDao productosDao;
    private VendedoresDao vendedoresDao;

    public ConsultasController() {
        productosDao = new ProductosDao();
        vendedoresDao = new VendedoresDao();
    }

    public List<ProductosVo> listarProductos() throws SQLException {
        return productosDao.listar();
    }

    public List<VendedoresVo> listarVendedores() throws SQLException {
        return vendedoresDao.listar();
    }

    public ProductosVo agregarNuevoProducto() throws SQLException {
        return productosDao.agregarNuevo();
    }

    public VendedoresVo agregarNuevoVendedor() throws SQLException {
        return vendedoresDao.agregarNuevo();
    }

    public ProductosVo eliminarProducto() throws SQLException {
        return productosDao.eliminar();
    }

    public VendedoresVo eliminarVendedor() throws SQLException {
        return vendedoresDao.eliminar();
    }

    public ProductosVo actualizarProducto() throws SQLException {
        return productosDao.actualizar();
    }

    public VendedoresVo actualizarVendedor() throws SQLException {
        return vendedoresDao.actualizar();
    }
}
