package ventahelados.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ventahelados.proyecto.services.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;
}
