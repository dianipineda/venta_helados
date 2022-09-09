package ventahelados.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.VentaModel;

@Repository
public interface VentaRepository extends CrudRepository<VentaModel, Long> {

}
