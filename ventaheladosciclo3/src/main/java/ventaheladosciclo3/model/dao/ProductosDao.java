package ventaheladosciclo3.model.dao;

import java.sql.SQLException;
import java.util.List;

import ventaheladosciclo3.model.vo.ProductosVo;

public interface ProductosDao extends DAO<ProductosVo> {
    void agregarNuevo(ProductosVo p) throws SQLException;

    void eliminar(ProductosVo p) throws SQLException;

    List<ProductosVo> listar() throws SQLException;

    void modificar(ProductosVo p);

}
