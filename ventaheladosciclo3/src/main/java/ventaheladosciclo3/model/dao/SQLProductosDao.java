package ventaheladosciclo3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
        String estado = rs.getString("estado");
        ProductosVo producto = new ProductosVo(codigo, descripcion, pAdmin, pVendedor, pPublico, estado);
        return producto;
    }

    private boolean validarQueNoEsteCod(int cod) throws SQLException {
        String busqueda = "select cod_producto from productos where cod_producto = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(busqueda);
            pst.setInt(1, cod);
            rs = pst.executeQuery();
            int codP;
            if (rs.next()) {
                codP = rs.getInt("cod_producto");
                return true;
            }

        } catch (Exception e) {
            new DAOException("Error: " + e.getMessage());
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
        return false;
    }

    private boolean validarQueSiEsteCod(int cod) throws SQLException {
        conn = conectar();
        String busqueda = "select cod_producto from productos where cod_producto=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(busqueda);
            pst.setInt(1, cod);
            rs = pst.executeQuery();
            int codP;
            if (rs.next()) {
                codP = rs.getInt("cod_producto");
                return true;
            }

        } catch (Exception e) {
            new DAOException("Error: " + e.getMessage());
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    @Override
    public void agregarNuevo(ProductosVo cod) throws SQLException {
        // TODO Auto-generated method stub
        String consulta = "insert into productos (id_producto, cod_producto, descripcion, precio_admin, precio_vendedor, precio_publico, estado) values (null, ?, ?, ?, ?, ?, 'ACTIVO')";
        conn = conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod.getCod());
            ps.setString(2, cod.getDescripcion());
            ps.setDouble(3, cod.getPrecioAdmin());
            ps.setDouble(4, cod.getPrecioVendedor());
            ps.setDouble(5, cod.getPrecioPublico());

            // validar //! falta aplicar roll back
            if (validarQueNoEsteCod(cod.getCod()) == true) {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos",
                        "Error al registrar producto", JOptionPane.INFORMATION_MESSAGE);
            }
            ;
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
    public void eliminar(ProductosVo cod) throws SQLException {
        // TODO Auto-generated method stub
        String consulta = "delete from productos where cod_producto= ?";
        conn = conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, cod.getCod());
            // validar://! falta aplicar roll back
            if (validarQueSiEsteCod(cod.getCod()) == false) {
                JOptionPane.showMessageDialog(null, "El producto no se encuentra en la base de datos",
                        "Error al eliminar producto", JOptionPane.INFORMATION_MESSAGE);
            }
            // el sistema pide confirmacion al usuario sobre eliminar el registro: la
            // ! confirmacion no funciona
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

    // ! Modificar funciona parcialmente pues no puede sobrescribir constructores
    // para mismo tipo de datos
    @Override
    public void modificar(ProductosVo cod, ProductosVo parametro, String campo) throws SQLException { // String

        String updateQuery = "UPDATE productos set";

        String editCod = "update productos set cod_producto = ? where cod_producto =?";
        String editDesc = "update productos set descripcion = ? where cod_producto =?";
        String editPAdmin = "update productos set precio_admin = ? where cod_producto= ?";
        String editPVend = "update productos set precio_vendedor = ? where cod_producto = ?";
        String editPpub = "update productos set precio_publico = ? where cod_producto = ?";
        String editEst = "update productos set estado = ? where cod_producto = ?";
        conn = conectar();
        PreparedStatement ps = null;
        try {
            switch (campo) {
                case "cod_producto":
                    ps = conn.prepareStatement(editCod);
                    ps.setInt(1, parametro.getCod());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;

                case "descripcion":
                    ps = conn.prepareStatement(editDesc);
                    ps.setString(1, parametro.getDescripcion());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;
                case "precio_admin":
                    ps = conn.prepareStatement(editPAdmin);
                    ps.setDouble(1, parametro.getPrecioAdmin());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;
                case "precio_vendedor":
                    ps = conn.prepareStatement(editPVend);
                    ps.setDouble(1, parametro.getPrecioVendedor());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;
                case "precio_publico":
                    ps = conn.prepareStatement(editPpub);
                    ps.setDouble(1, parametro.getPrecioPublico());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;
                case "estado":
                    ps = conn.prepareStatement(editEst);
                    ps.setString(1, parametro.getEstado());
                    ps.setInt(2, cod.getCod());
                    ps.executeUpdate();
                    break;
            }

        } catch (Exception e) {
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

    // TODO: Quedé aquí:
    public void editar(ProductosVo cod, HashMap<String, Object> parametros) throws DAOException, SQLException {
        String consulta = "update productos set";
        conn = conectar();
        PreparedStatement ps = null;
        parametros.put("cod_producto", '?');
        parametros.put("descripcion", '?');
        parametros.put("precio_admin", '?');
        parametros.put("precio_vendedor", '?');
        parametros.put("precio_publico", '?');
        parametros.put("estado", '?');
        for (HashMap.Entry<String, Object> entry : parametros.entrySet()) {
            String consulta2 = entry.getKey() + "=" + entry.getValue();
        }

        // for (List elemento : lista) {
        // if(no_es_el_ultimo_elemento) {
        // updateQuery.concat(" "+elemento.llave+"="+elemento.valor",");
        // } else {
        // updateQuery.concat(" "+elemento.llave+"="+elemento.valor);
        // }
        // }

        // updateQuery.concat("WHERE cod_producto = ?");
    }

    // ? funcion utilizada para editar (version 2 de modificar)
    private List<ProductosVo> getProducto(int cod) throws SQLException {
        // TODO Auto-generated method stub
        List<ProductosVo> producto = new ArrayList<ProductosVo>();
        conn = conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "select * from productos where cod_producto = ?";
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.add(convertir(rs));
            }
        } catch (SQLException e) {
            new DAOException("Error: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return producto;
    }

}
