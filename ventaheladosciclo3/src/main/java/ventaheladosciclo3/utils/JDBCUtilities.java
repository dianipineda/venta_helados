package ventaheladosciclo3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JDBCUtilities {
    Connection conectar;
    String usuario = "root";
    String contrasenia = "mysql123";
    String bd = "ventahelados";
    String ip = "localhost";
    String puerto = "3306";
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente a la base de datos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas al intentar conectar a la base de datos");
        }
        return conectar;
    }

}
