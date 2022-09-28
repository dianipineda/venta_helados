package ventahelados.proyecto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.models.VendedorModel;
import ventahelados.proyecto.repositories.VendedorRepository;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    public VendedorModel agregarVendedor(VendedorModel vendedor) {
        VendedorModel buscar = vendedorRepository.findByCc(vendedor.getCc());
        if (buscar != null) {
            return null;
        } else {
            VendedorModel v = new VendedorModel();
            v.setNombre1(vendedor.getNombre1().toUpperCase());
            v.setNombre2(vendedor.getNombre2().toUpperCase());
            v.setApellido1(vendedor.getApellido1().toUpperCase());
            v.setApellido2(vendedor.getApellido2().toUpperCase());
            v.setCc(vendedor.getCc());
            v.setCelular(vendedor.getCelular());
            v.setCumpleAnios(vendedor.getCumpleAnios());
            v.setEstado("activo".toLowerCase());
            return vendedorRepository.save(v);
        }
    }

    public ArrayList<VendedorModel> findAllActivos() {
        return vendedorRepository.findAllActivos();
    }

    public VendedorModel findByCc(Integer cc) {
        return vendedorRepository.findByCc(cc);
    }

    public VendedorModel findById(Integer id) {
        return vendedorRepository.findById(id).get();
    }

    // *ok solo modifica estado, falta relacionarlo con un condicional para que
    // edite los demas campos si no encuentra la cedula de venta
    public void editarVendedor(VendedorModel vendedor) {
        VendedorModel v = vendedorRepository.getReferenceById(vendedor.getId());
        v.setNombre1(vendedor.getNombre1().toUpperCase());
        v.setNombre2(vendedor.getNombre2().toUpperCase());
        v.setApellido1(vendedor.getApellido1().toUpperCase());
        v.setApellido2(vendedor.getApellido2().toUpperCase());
        v.setCc(vendedor.getCc());
        v.setCelular(vendedor.getCelular());
        v.setCumpleAnios(vendedor.getCumpleAnios());
        v.setEstado(vendedor.getEstado().toLowerCase());
        vendedorRepository.save(v);
    }

}
