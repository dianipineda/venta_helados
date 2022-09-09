package ventahelados.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.VendedorModel;

@Repository
public interface VendedorRepository extends CrudRepository<VendedorModel, Integer> {

}
