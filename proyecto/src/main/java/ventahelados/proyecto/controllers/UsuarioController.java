package ventahelados.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ventahelados.proyecto.models.UsuarioModel;
import ventahelados.proyecto.services.UsuarioService;

@Controller
@RequestMapping()
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login_usuario")
    public String login(Model model) {
        model.addAttribute("usuarioModel", new UsuarioModel());
        return "index";
    }

}
