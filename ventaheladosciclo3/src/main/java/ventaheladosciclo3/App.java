package ventaheladosciclo3;

import java.sql.SQLException;
import ventaheladosciclo3.controller.SQLDAOManager;
import ventaheladosciclo3.model.vo.ProductosVo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        SQLDAOManager manager = new SQLDAOManager();
        // manager.getProductosDao().agregarNuevo(new ProductosVo(161113, "PRODUCTO
        // PRUEBA", 1800.0, 2000.0, 2500.0));
        // manager.getProductosDao().eliminar(new ProductosVo(12345));
        // System.out.println(manager.getProductosDao().listar());
        manager.getProductosDao().modificar(new ProductosVo(161113), 2500, "precio_vendedor");
        // System.out.println(manager.getProductosDao().listar());

    }
}
