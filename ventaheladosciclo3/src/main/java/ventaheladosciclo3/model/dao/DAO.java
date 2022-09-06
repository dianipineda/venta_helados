package ventaheladosciclo3.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<C, O> {
    void agregarNuevo(C p) throws DAOException, SQLException;

    void eliminar(C p) throws DAOException, SQLException;

    List<C> listar() throws DAOException, SQLException;

    void modificar(C p, O p2, String campo) throws DAOException, SQLException;

}
