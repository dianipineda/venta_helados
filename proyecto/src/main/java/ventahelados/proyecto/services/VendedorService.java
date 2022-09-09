package ventahelados.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.repositories.VendedorRepository;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;
}
