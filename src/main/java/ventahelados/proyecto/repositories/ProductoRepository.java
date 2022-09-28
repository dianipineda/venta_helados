package ventahelados.proyecto.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {
    @Query(value = "select * from productos where estado_producto ='activo';", nativeQuery = true)
    public abstract ArrayList<ProductoModel> findAllActivos();

    public ProductoModel getReferenceById(Integer id);

    public abstract ProductoModel findByCodigo(Integer codigo);

    public abstract ProductoModel findByDescripcion(String descripcion);

}
