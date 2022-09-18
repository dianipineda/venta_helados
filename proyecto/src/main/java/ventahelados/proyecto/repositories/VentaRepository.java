package ventahelados.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.VentaModel;

@Repository
public interface VentaRepository extends JpaRepository<VentaModel, Long> {

}
