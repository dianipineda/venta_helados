package ventaheladosciclo3.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<C> {
    void agregarNuevo(C p) throws DAOException, SQLException;

    void eliminar(C p) throws DAOException, SQLException;

    List<C> listar() throws DAOException, SQLException;

    void modificar(C p) throws DAOException;

}
