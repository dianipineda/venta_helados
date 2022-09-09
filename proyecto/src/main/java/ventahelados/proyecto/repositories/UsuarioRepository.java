package ventahelados.proyecto.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
}
