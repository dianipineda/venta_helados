package ventahelados.proyecto.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ventahelados.proyecto.models.UsuarioModel;
import ventahelados.proyecto.services.UsuarioService;

@RestController
@RequestMapping("/administrador")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel agregarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.agregarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Integer id) {
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> findByNombre(@RequestParam("nombre") String nombre) {
        return usuarioService.findByNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarUsuario(@PathVariable("id") Integer id) {
        return usuarioService.eliminarUsuario(id);
    }

}
