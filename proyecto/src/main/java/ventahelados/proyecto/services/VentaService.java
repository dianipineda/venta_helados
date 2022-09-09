package ventahelados.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventahelados.proyecto.repositories.VentaRepository;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;
}
