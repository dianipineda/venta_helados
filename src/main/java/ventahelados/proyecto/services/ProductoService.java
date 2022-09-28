package ventahelados.proyecto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ventahelados.proyecto.models.ProductoModel;
import ventahelados.proyecto.repositories.ProductoRepository;

@Service
@Transactional
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
            p.setDescripcion(producto.getDescripcion().toUpperCase());
            p.setpAdmin(producto.getpAdmin());
            p.setpVendedor(producto.getpVendedor());
            p.setpPublico(producto.getpPublico());
            p.setEstado("activo".toLowerCase());
            return productoRepository.save(p);

        }
    }

    // *ok
    public ArrayList<ProductoModel> findAllActivos() {
        return productoRepository.findAllActivos();
    }

    // *ok
    public ProductoModel findByCodigo(Integer codigo) {
        return productoRepository.findByCodigo(codigo);
    }

    // *ok
    public ProductoModel findByDescripcion(String descripcion) {
        return productoRepository.findByDescripcion(descripcion);
    }

    public ProductoModel findById(Integer id) {
        return productoRepository.findById(id).get();
    }

    // *ok
    public void editarProducto(ProductoModel producto) {
        ProductoModel p = productoRepository.getReferenceById(producto.getId());
        p.setDescripcion(producto.getDescripcion().toUpperCase());
        p.setpAdmin(producto.getpAdmin());
        p.setpVendedor(producto.getpVendedor());
        p.setpPublico(producto.getpPublico());
        p.setEstado(producto.getEstado().toLowerCase());
        productoRepository.save(p);

    }

}
