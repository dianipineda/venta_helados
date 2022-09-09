package ventahelados.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {
    public abstract ProductoModel findByCodigo(Integer codigo);

    public abstract ProductoModel findByDescripcion(String descripcion);

}

// @Modifying
// @Query(value = "update productos set estado_producto= ?1 where cod_producto =
// ?2", nativeQuery = true)
// public abstract ProductoModel modifyEstadoByCodigo(String estado, Integer
// codigo);

// "update ProductoModel p set p.estado=?1 where p.codigo=?2"