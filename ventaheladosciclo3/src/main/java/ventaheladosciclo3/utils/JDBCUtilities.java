package ventaheladosciclo3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class JDBCUtilities {
    private static Connection conectar;
    private static String usuario = "root";
    private static String contrasenia = "mysql123";
    private static String bd = "ventahelados";
    private static String ip = "localhost";
    private static String puerto = "3306";
    private static String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public static Connection establecerConexion() throws SQLException {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente a la base de datos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas al intentar conectar a la base de datos");
        }
        return conectar;
    }

}
