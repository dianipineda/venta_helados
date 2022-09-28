package ventahelados.proyecto.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.VendedorModel;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {

    @Query(value = "select * from vendedores where estado_vendedor = 'activo';", nativeQuery = true)

    public abstract ArrayList<VendedorModel> findAllActivos();

    public VendedorModel getReferenceById(Integer id);

    public abstract VendedorModel findByCc(Integer cc);

}
