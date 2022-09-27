package ventahelados.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventahelados.proyecto.models.VentaModel;
import ventahelados.proyecto.repositories.VentaRepository;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public void agregarVenta(VentaModel venta) {
        VentaModel v = new VentaModel();
        v.setFechaHoraVenta(venta.getFechaHoraVenta());
        v.setProducto(venta.getProducto());
        v.setVendedor(venta.getVendedor());
        v.setCantidadEntrega(venta.getCantidadEntrega());
        v.setCantidadRecibe(venta.getCantidadRecibe());
        ventaRepository.save(v);
    }

}
