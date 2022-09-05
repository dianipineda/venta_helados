package ventaheladosciclo3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ventaheladosciclo3.model.vo.ProductosVo;
import ventaheladosciclo3.utils.JDBCUtilities;

public class SQLProductosDao implements ProductosDao {

    Connection conn;

    private Connection conectar() throws SQLException {
        return JDBCUtilities.conectar();
    }

    private ProductosVo convertir(ResultSet rs) throws SQLException {

        int codigo = rs.getInt("cod_producto");
        String descripcion = rs.getString("descripcion");
        double pAdmin = rs.getFloat("precio_admin");
        double pVendedor = rs.getFloat("precio_vendedor");
        double pPublico = rs.getFloat("precio_publico");
        ProductosVo producto = new ProductosVo(codigo, descripcion, pAdmin, pVendedor, pPublico);
        return producto;
    }

    @Override
    public void agregarNuevo(ProductosVo p) throws SQLException {
        // TODO Auto-generated method stub
        String consulta = "insert into productos (id_producto, cod_producto, descripcion, precio_admin, precio_vendedor, precio_publico, estado) values (null, ?, ?, ?, ?, ?, 'ACTIVO')";
        String validacion = "select cod_producto from productos where cod_producto = ?";
        conn = conectar();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = conn.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getCod());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecioAdmin());
            ps.setDouble(4, p.getPrecioVendedor());
            ps.setDouble(5, p.getPrecioPublico());

            // validar codigo repetido existente en BBDD
            try {
                ps2 = conn.prepareStatement(validacion);
                ps2.setInt(1, p.getCod());
                ps2.executeQuery();
                // ! implementar a la coneccion commit y rollback en caso de la validación:
                if (ps2.executeQuery() != null) {
                    System.out.println("se puede continuar");
                } else {
                    System.out.println("se debe parar el proceso e impedir guardar cambios");
                }
            } catch (Exception e) {
                new DAOException("Error: " + e.getMessage());
            } finally {
                if (ps2 != null) {
                    ps2.close();
                }
            }
            // Guardar cambios
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El producto  fue agregado correctamente", "se creó un nuevo producto",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            new DAOException("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

    }

    @Override
    public void eliminar(ProductosVo p) throws SQLException {
        // TODO Auto-generated method stub
        String consulta = "delete from productos where cod_producto= ?";
        String busqueda = "select cod_producto from productos where cod_producto=?";
        conn = conectar();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, p.getCod());
            try {
                ps2 = conn.prepareStatement(busqueda);
                ps2.setInt(1, p.getCod());
                ps2.executeQuery();
                // ! implementar a la coneccion commit y rollback en caso de la validación:
                if (ps2.executeQuery() != null) {
                    System.out.println("se puede continuar con la eliminacion");
                } else {
                    System.out.println(
                            "se debe parar el proceso para no ejecutar las sentencias siguientes de eliminar, ademas alertar al usuario de que no existe un producto por eliminar");
                }
            } catch (Exception e) {
                new DAOException("Error: " + e.getMessage());
            } finally {
                if (ps2 != null) {
                    ps2.close();
                }
            }
            // el sistema pide confirmacion al usuario sobre eliminar el registro
            JOptionPane.showConfirmDialog(null, "estas seguro de eliminar este producto", "Confirmar cambios",
                    JOptionPane.YES_NO_OPTION);
            ps.executeUpdate();
        } catch (SQLException e) {
            new DAOException("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

    }

    @Override
    public List<ProductosVo> listar() throws SQLException {
        // TODO Auto-generated method stub
        List<ProductosVo> productos = new ArrayList<ProductosVo>();
        conn = conectar();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select * from productos where estado = 'ACTIVO'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                productos.add(convertir(rs));
            }
        } catch (SQLException e) {
            new DAOException("Error: " + e.getMessage());
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
        return productos;
    }

    @Override
    public void modificar(ProductosVo p) {
        // TODO Auto-generated method stub

    }

}
