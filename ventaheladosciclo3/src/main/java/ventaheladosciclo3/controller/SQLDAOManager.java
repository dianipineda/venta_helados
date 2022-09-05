package ventaheladosciclo3.controller;

import java.sql.SQLException;

import ventaheladosciclo3.model.dao.ProductosDao;
import ventaheladosciclo3.model.dao.SQLProductosDao;
import ventaheladosciclo3.model.dao.VendedoresDao;

public class SQLDAOManager implements DAOManager {

    private ProductosDao producto = null;
    private VendedoresDao vendedor = null;

    @Override
    public ProductosDao getProductosDao() throws SQLException {
        if (producto == null) {
            producto = new SQLProductosDao();
        }
        return producto;
    }

    @Override
    public VendedoresDao getVendedoresDao() {
        // TODO Auto-generated method stub
        return null;
    }
}
