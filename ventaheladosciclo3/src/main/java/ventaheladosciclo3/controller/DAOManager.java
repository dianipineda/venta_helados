package ventaheladosciclo3.controller;

import java.sql.SQLException;

import ventaheladosciclo3.model.dao.ProductosDao;
import ventaheladosciclo3.model.dao.VendedoresDao;

public interface DAOManager {
    ProductosDao getProductosDao() throws SQLException;

    VendedoresDao getVendedoresDao();
}
