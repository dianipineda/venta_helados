package ventaheladosciclo3.model.dao;

import java.sql.SQLException;
import java.util.List;

import ventaheladosciclo3.model.vo.ProductosVo;

public interface ProductosDao extends DAO<ProductosVo> {
    void agregarNuevo(ProductosVo cod) throws SQLException;

    void eliminar(ProductosVo cod) throws SQLException;

    List<ProductosVo> listar() throws SQLException;

    void modificar(ProductosVo cod, ProductosVo parametro, String campo) throws SQLException;

}
