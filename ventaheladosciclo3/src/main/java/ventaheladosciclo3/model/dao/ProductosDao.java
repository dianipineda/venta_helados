package ventaheladosciclo3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ventaheladosciclo3.model.vo.ProductosVo;
import ventaheladosciclo3.utils.JDBCUtilities;

public class ProductosDao {
    public List<ProductosVo> listar() {
        List<ProductosVo> result = new ArrayList<ProductosVo>();
        Connection conn = (Connection) new JDBCUtilities();
        ((JDBCUtilities) conn).establecerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "select * from Productos";
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
//hola
