package ventaheladosciclo3.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import ventaheladosciclo3.model.vo.ProductosVo;
import ventaheladosciclo3.utils.JDBCUtilities;

public class ProductosDao {
    public List<ProductosVo> listar() throws SQLException {
        List<ProductosVo> result = new ArrayList<ProductosVo>();
        Connection conn = JDBCUtilities.establecerConexion();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select * from productos";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                ProductosVo vo = new ProductosVo();
                vo.setId(rs.getInt("id_producto"));
                vo.setCod(rs.getInt("cod_producto"));
                vo.setDescripcion(rs.getString("descripcion"));
                vo.setPrecioAdmin(rs.getFloat("precio_admin"));
                vo.setPrecioVendedor(rs.getFloat("precio_vendedor"));
                vo.setPrecioPublico(rs.getFloat("precio_publico"));
                result.add(vo);

            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    // TODO: Quedé aqui:
    public ProductosVo agregarNuevo(int codigo, String descripcion, double pAdmin, double pVendedor, double pPublico,
            String estado) throws SQLException {
        Connection conn = JDBCUtilities.establecerConexion();
        String consulta = "insert into productos (cod_producto, descripcion, precio_admin, precio_vendedor, precio_publico, estado) values (?, ?, ?, ?, ?, ?)";
        return null;
    }

    public ProductosVo eliminar() throws SQLException {
        Connection conn = JDBCUtilities.establecerConexion();
        return null;
    }

    public ProductosVo actualizar() throws SQLException {
        Connection conn = JDBCUtilities.establecerConexion();
        return null;
    }
}
