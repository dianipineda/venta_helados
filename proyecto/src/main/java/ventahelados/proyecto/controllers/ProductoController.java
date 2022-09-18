package ventahelados.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.services.ProductoService;

@Controller
@RequestMapping()
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
    public String procesarRegistroProducto(ProductoModel productoModel) {
        productoService.agregarProducto(productoModel);
        return "registroProducto";

    }

    // *proceso listar producto
    @GetMapping()
    public ArrayList<ProductoModel> findAllActivos() {
        return productoService.findAllActivos();

    }

    // *form lista de productos:
    @GetMapping("/lista_productos")
    public String verListaProductos(Model model) {
        List<ProductoModel> listaProductos = productoService.findAllActivos();
        model.addAttribute("listaProductos", listaProductos);
        return "listoProducto";
    }

    @GetMapping("/buscarCodigo")
    public ProductoModel findByCodigo(@RequestParam("codigo") Integer codigo) {
        return productoService.findByCodigo(codigo);
    }

    @GetMapping("/buscarDescripcion")
    public ProductoModel findByDescripcion(@RequestParam("descripcion") String descripcion) {
        return productoService.findByDescripcion(descripcion);
    }

    @PutMapping
    public void editarProducto(@RequestBody ProductoModel producto) {
        productoService.editarProducto(producto);
    }

}
