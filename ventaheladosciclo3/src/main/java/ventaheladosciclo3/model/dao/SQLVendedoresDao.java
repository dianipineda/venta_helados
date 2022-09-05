package ventaheladosciclo3.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import ventaheladosciclo3.model.vo.VendedoresVo;
import ventaheladosciclo3.utils.JDBCUtilities;

public class SQLVendedoresDao {
    public List<VendedoresVo> listar() throws SQLException {
        List<VendedoresVo> result = new ArrayList<VendedoresVo>();
        Connection conn = JDBCUtilities.conectar();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono from vendedores";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                VendedoresVo vo = new VendedoresVo();

                vo.setCedula(rs.getInt("cedula"));
                vo.setPrimer_nombre(rs.getString("primer_nombre"));
                vo.setSegundo_nombre(rs.getString("segundo_nombre"));
                vo.setPrimer_apellido(rs.getString("primer_apellido"));
                vo.setSegundo_apellido(rs.getString("segundo_apellido"));
                vo.setTelefono(rs.getLong("telefono"));
                result.add(vo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    public VendedoresVo agregarNuevo() throws SQLException {

        return null;
    }

    public VendedoresVo eliminar() throws SQLException {
        return null;
    }

    public VendedoresVo actualizar() throws SQLException {
        return null;
    }

}
