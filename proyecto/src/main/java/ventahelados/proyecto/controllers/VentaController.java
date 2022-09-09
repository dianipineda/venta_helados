package ventahelados.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ventahelados.proyecto.services.VentaService;

@RestController
@RequestMapping("/vendedores")
public class VentaController {
    @Autowired
    VentaService ventaService;
}
