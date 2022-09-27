package ventahelados.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.models.UsuarioModel;
import ventahelados.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel findByEmailAndPassword(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }

}
