package ventahelados.proyecto.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.VendedorModel;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {
    public abstract VendedorModel findByCc(Integer cc);

    @Query("select v from VendedorModel v where v.estado = 'activo'")
    public abstract ArrayList<VendedorModel> findAllActivos();

}
