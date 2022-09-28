package ventahelados.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.services.ProductoService;

@Controller

public class ProductoController {
    @Autowired
    ProductoService productoService;

    // *formAgregarProducto
    @GetMapping("/view_registro_producto")
    public String verRegistroProducto(Model model) {
        model.addAttribute("productoModel", new ProductoModel());
        return "registroProducto";
    }

    // *proceso Agregar producto
    @PostMapping("/agregar_producto")
    public String procesarRegistroProducto(@ModelAttribute ProductoModel productoModel) {
        productoService.agregarProducto(productoModel);
        return "redirect:/lista_productos";

    }

    // *form lista de productos:
    @GetMapping("/lista_productos")
    public String verListaProductos(Model model) {
        List<ProductoModel> listaProductos = productoService.findAllActivos();
        model.addAttribute("listaProductos", listaProductos);
        return "listoProducto";
    }

    // *proceso listar producto
    @GetMapping()
    public ArrayList<ProductoModel> findAllActivos() {
        return productoService.findAllActivos();

    }

    // *form Edito producto
    @RequestMapping("/view_edito_producto/{id}")
    public ModelAndView verEditoProducto(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("modificoProducto");
        ProductoModel p = productoService.findById(id);
        mav.addObject("productoModel", p);
        return mav;
    }

    // *Proceso Modifico producto
    @RequestMapping(value = "/modificar_producto", method = RequestMethod.GET)
    public String procesarEditarProducto(@ModelAttribute ProductoModel productoModel) {
        productoService.editarProducto(productoModel);
        return "redirect:/lista_productos";
    }

    @GetMapping("/buscarDescripcion")
    public ProductoModel findByDescripcion(@RequestParam("descripcion") String descripcion) {
        return productoService.findByDescripcion(descripcion);
    }

}
