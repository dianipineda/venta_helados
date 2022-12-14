package ventahelados.proyecto.controllers;

import java.util.Arrays;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ventahelados.proyecto.models.VendedorModel;
import ventahelados.proyecto.services.VendedorService;

@Controller
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    // *formAgregarVendedor
    @GetMapping("/view_registro_vendedor")
    public String verRegistroVendedor(Model model) {
        model.addAttribute("vendedorModel", new VendedorModel());
        return "registroVendedor";
    }

    // *proceso Agregar vendedor
    @PostMapping("/agregar_vendedor")
    public String procesarRegistroVendedor(@ModelAttribute VendedorModel vendedorModel) {
        vendedorService.agregarVendedor(vendedorModel);
        return "redirect:/lista_vendedores";

    }

    // *form lista de vendedor:
    @GetMapping("/lista_vendedores")
    public String verListaVendedores(Model model) {
        List<VendedorModel> listaVendedores = vendedorService.findAllActivos();
        model.addAttribute("listaVendedores", listaVendedores);
        return "listoVendedor";
    }

    // *form Edito Vendeddor
    @RequestMapping("/view_edito_vendedor/{id}")
    public ModelAndView verEditoVendedor(@PathVariable(name = "id") int id, Model model) {
        ModelAndView mav = new ModelAndView("modificoVendedor");
        VendedorModel v = vendedorService.findById(id);
        mav.addObject("vendedorModel", v);
        List<String> listEstado = Arrays.asList("activo", "inactivo");
        model.addAttribute("listEstado", listEstado);
        return mav;
    }

    // *Proceso Modifico Vendedor
    @RequestMapping(value = "/modificar_vendedor", method = RequestMethod.GET)
    public String procesarEditarVendedor(@ModelAttribute VendedorModel vendedorModel, RedirectAttributes attribute) {
        vendedorService.editarVendedor(vendedorModel);
        attribute.addFlashAttribute("mensaje", "Estado de Vendedor Editado con Exito.");
        attribute.addFlashAttribute("clase", "success");
        return "redirect:/lista_vendedores";
    }

}
