package ventaheladosciclo3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class JDBCUtilities {
    private static Connection conn;
    private static String usuario = "root";
    private static String contrasenia = "mysql123";
    private static String bd = "ventahelados";
    private static String ip = "localhost";
    private static String puerto = "3306";

    public static Connection conectar() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + bd, usuario, contrasenia);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Problemas al intentar conectar a la base de datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

}
