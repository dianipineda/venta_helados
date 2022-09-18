package ventahelados.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    // public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract UsuarioModel findByNombre(String nombre);

    public abstract UsuarioModel findByPassword(String password);
}
