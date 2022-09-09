package ventahelados.proyecto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @PostMapping()
    public ProductoModel agregarProducto(@RequestBody ProductoModel producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/buscarCodigo")
    public ProductoModel findByCodigo(@RequestParam("codigo") Integer codigo) {
        return productoService.findByCodigo(codigo);
    }

    @GetMapping("/buscarDescripcion")
    public ProductoModel findByDescripcion(@RequestParam("descripcion") String descripcion) {
        return productoService.findByDescripcion(descripcion);
    }

    // @PutMapping
    // public ProductoModel modifyEstadoByCodigo(@RequestParam("estado") String
    // estado,
    // @RequestParam("codigo") Integer codigo) {
    // return productoService.modifyEstadoByCodigo(estado, codigo);
    // }
    @PutMapping
    public void editarProducto(@RequestBody ProductoModel producto) {
        productoService.editarProducto(producto);
    }

}
