package ventahelados.proyecto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    // *ok

    public ProductoModel agregarProducto(ProductoModel producto) {
        ProductoModel buscar = productoRepository.findByCodigo(producto.getCodigo());
        if (buscar != null) {
            return null;
        } else {
            ProductoModel p = new ProductoModel();
            p.setCodigo(producto.getCodigo());
            p.setDescripcion(producto.getDescripcion());
            p.setpAdmin(producto.getpAdmin());
            p.setpVendedor(producto.getpVendedor());
            p.setpPublico(producto.getpPublico());
            p.setEstado("activo");
            return productoRepository.save(p);

        }
    }

    // *ok
    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    // *ok
    public ProductoModel findByCodigo(Integer codigo) {
        return productoRepository.findByCodigo(codigo);
    }

    // *ok
    public ProductoModel findByDescripcion(String descripcion) {
        return productoRepository.findByDescripcion(descripcion);
    }

    // *ok
    public void editarProducto(ProductoModel producto) {
        ProductoModel p = productoRepository.findByCodigo(producto.getCodigo());
        p.setEstado(producto.getEstado());
        productoRepository.save(p);
    }

}
