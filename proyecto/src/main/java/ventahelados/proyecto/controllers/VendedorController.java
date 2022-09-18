package ventahelados.proyecto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ventahelados.proyecto.models.VendedorModel;
import ventahelados.proyecto.services.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    @GetMapping("/buscarCedula")
    public VendedorModel findByCc(@RequestParam("cedula") Integer cc) {
        return vendedorService.findByCc(cc);
    }

    @GetMapping()
    public ArrayList<VendedorModel> findAllActivos() {
        return vendedorService.findAllActivos();
    }

    @PostMapping()
    public void agregarVendedor(@RequestBody VendedorModel vendedor) {
        vendedorService.agregarVendedor(vendedor);
    }
}
