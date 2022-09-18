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

    public VendedorModel findByCc(Integer cc) {
        return vendedorRepository.findByCc(cc);
    }

    public ArrayList<VendedorModel> findAllActivos() {
        return vendedorRepository.findAllActivos();
    }

    public void agregarVendedor(VendedorModel vendedor) {
        VendedorModel buscar = vendedorRepository.findByCc(vendedor.getCc());
        VendedorModel v = new VendedorModel();
        if (buscar == null) {
            try {
                v.setCc(vendedor.getCc());
                v.setNombre1(vendedor.getNombre1().toUpperCase());
                v.setNombre2(vendedor.getNombre2().toUpperCase());
                v.setApellido1(vendedor.getApellido1().toUpperCase());
                v.setApellido2(vendedor.getApellido2().toUpperCase());
                v.setCumpleAnios(vendedor.getCumpleAnios());
                v.setTelefono(vendedor.getTelefono());
                v.setEstado("activo".toLowerCase());
                vendedorRepository.save(v);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            System.err.println("error");
        }

    }

    // *ok solo modifica estado, falta relacionarlo con un condicional para que
    // edite los demas campos si no encuentra la cedula de venta
    public void editarVendedor(VendedorModel vendedor) {
        VendedorModel v = vendedorRepository.findByCc(vendedor.getCc());
        v.setEstado(vendedor.getEstado());
        vendedorRepository.save(v);
    }
}
