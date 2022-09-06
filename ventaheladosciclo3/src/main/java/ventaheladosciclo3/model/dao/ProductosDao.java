package ventaheladosciclo3.model.dao;

import java.sql.SQLException;
import java.util.List;

import ventaheladosciclo3.model.vo.ProductosVo;

public interface ProductosDao extends DAO<ProductosVo, Object> {
    void agregarNuevo(ProductosVo cod) throws SQLException;

    void eliminar(ProductosVo cod) throws SQLException;

    List<ProductosVo> listar() throws SQLException;

    void modificar(ProductosVo cod, Object parametro, String campo) throws SQLException;

}
