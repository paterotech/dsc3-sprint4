package edu.udea.main.controladores;

import edu.udea.main.entidades.Empresa;
import edu.udea.main.entidades.Movimiento;
import edu.udea.main.repositorios.IEmpresaRepo;
import edu.udea.main.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControladorEmpresa {

    @Autowired
    private ServicioEmpresa servicioEmpresa;

    // ***** LISTAR EMPRESAS *****//

    @GetMapping({"/empresas"})
    public String listarEmpresas(Model modelo) {
        List<Empresa> empresas = servicioEmpresa.listarEmpresa();
        modelo.addAttribute("empresas", empresas);
        return "empresas";
    }


    // ***** CREAR NUEVO REGISTRO ***** //

    @GetMapping("/nuevoRegEmpr")
    public String mostrarFormEmpr(Model modelo) {
        modelo.addAttribute("empresas", new Empresa());
        return "nuevoRegEmpr";
    }

    @PostMapping("/nuevoRegEmpr")
    public String crearNuevaEmpresa(@Validated @DateTimeFormat(pattern = "YYYY-MM-DD") Empresa empresa, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("empresas", empresa);
            return "/nuevoRegEmpr";
        }
        servicioEmpresa.guardarEmpresa(empresa);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
        return "redirect:/empresas";
    }


    // ***** MODIFICAR REGISTROS ***** //

    @GetMapping("/{id}/editar/empresa")
    public String mostrarFormularioDeEditarEmpr(@PathVariable Long id, Model modelo) {
        Empresa empresa = servicioEmpresa.obtenerEmpresa(id);
        modelo.addAttribute("empresas", empresa);
        return "editarRegEmpr";
    }


    @PostMapping("/{id}/editar/empresa")
    public String actualizarEmpr(@PathVariable Long id, @ModelAttribute("empresas") Empresa empresa, Model modelo) {
        Empresa emprActual = servicioEmpresa.obtenerEmpresa(id);
        emprActual.setId(id);
        emprActual.setNombre(empresa.getNombre());
        emprActual.setNit(empresa.getNit());
        emprActual.setDireccion(empresa.getDireccion());
        emprActual.setTelefono(empresa.getTelefono());
        emprActual.setFechaCreacion(empresa.getFechaCreacion());
        servicioEmpresa.guardarEmpresa(emprActual);
        return "redirect:/empresas";
    }

    // ***** ELIMINAR REGISTRO ***** //

    @PostMapping("/{id}/eliminar/empresas")
    public String eliminarEmpresa(@PathVariable Long id,RedirectAttributes redirect) {
        Empresa empresa = servicioEmpresa.obtenerEmpresa(id);
        servicioEmpresa.eliminarEmpresa(empresa.id);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
        return "redirect:/empresas";
    }



}
