package ventaheladosciclo3.model.dao;

import java.util.List;

import ventaheladosciclo3.model.vo.VendedoresVo;

public interface VendedoresDao {
    void agregarNuevo(VendedoresVo p);

    void eliminar(VendedoresVo p);

    List<VendedoresVo> listar();

    void modificar(VendedoresVo p);
}
