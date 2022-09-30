package ventahelados.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ventahelados.proyecto.models.UsuarioModel;
import ventahelados.proyecto.services.UsuarioService;

@Controller

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String login(Model model) {
        UsuarioModel usuario = new UsuarioModel();
        model.addAttribute("usuarios", usuario);
        return "index";
    }

    @PostMapping("/usuarioLogin")
    public String Login(@ModelAttribute("usuarios") UsuarioModel usuario, RedirectAttributes attribute) {
        UsuarioModel data = usuarioService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
        if (data != null) {
            return "principal";
        } else {
            attribute.addFlashAttribute("mensaje", "Correo y/o Contraseña no válidos, Intente Nuevamente");
            attribute.addFlashAttribute("clase", "success");
            return "redirect:/";
        }

    }

    @GetMapping("/principal")
    public String principal() {
        return "principal";
    }

}
