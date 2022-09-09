package ventahelados.proyecto.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.models.UsuarioModel;
import ventahelados.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // * ok básico
    public UsuarioModel agregarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // *ok básico
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> findByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public boolean eliminarUsuario(Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
