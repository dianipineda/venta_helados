package ventahelados.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.models.VentaModel;
import ventahelados.proyecto.services.ProductoService;
import ventahelados.proyecto.services.VendedorService;
import ventahelados.proyecto.services.VentaService;

@Controller
public class VentaController {
    @Autowired
    VentaService ventaService;
    VendedorService vendedorService;
    ProductoService productoService;

    // *formAgregarVenta
    @GetMapping("/view_registro_venta")
    public String verRegistroVenta(Model model) {
        // ! causa error nullpointerException
        // List<ProductoModel> listaProductos = productoService.findAllActivos();
        // model.addAttribute("listaProductos", listaProductos);
        model.addAttribute("ventaModel", new VentaModel());
        return "ventaDiaria";
    }

    // *proceso Agregar venta
    @PostMapping("/agregar_venta")
    public String procesarRegistroVenta(@ModelAttribute VentaModel ventaModel) {
        ventaService.agregarVenta(ventaModel);
        return "redirect:/view_registro_venta";
    }
}