package ventaheladosciclo3;

import java.sql.SQLException;
import ventaheladosciclo3.controller.ConsultasController;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        ConsultasController consulta = new ConsultasController();
        System.out.println(consulta.listarProductos());
        System.out.println(consulta.listarVendedores());
    }
}
