package ventahelados.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ventahelados.proyecto.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    public abstract UsuarioModel findByEmailAndPassword(String email, String password);
}
