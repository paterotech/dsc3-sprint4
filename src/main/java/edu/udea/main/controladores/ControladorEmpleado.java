package edu.udea.main.controladores;

import edu.udea.main.entidades.Empleado;
import edu.udea.main.entidades.Empresa;
import edu.udea.main.entidades.Role;
import edu.udea.main.servicios.ServicioEmpleado;
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
public class ControladorEmpleado {

    @Autowired
    private ServicioEmpleado servicio;

    // ***** LISTAR EMPLEADOS ***** //

    @GetMapping({"/empleados"})
    public String listarEmpleados(Model modelo) {
        List<Empleado> empleados = servicio.listarEmpleado();
        modelo.addAttribute("empleados", empleados);
        return "empleados";
    }


    // ***** CREAR NUEVO REGISTRO ***** //

    @GetMapping("/nuevoRegEmpl")
    public String mostrarFormEmpl(Model modelo) {
        modelo.addAttribute("empleados", new Empleado());
        modelo.addAttribute("Roles", Role.values());
        return "nuevoRegEmpl";
    }

    @PostMapping("/nuevoRegEmpl")
    public String crearNuevaEmpresa(@Validated @DateTimeFormat(pattern = "YYYY-MM-DD") Empleado empleado, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("empleados", empleado);
            return "/nuevoRegEmpl";
        }
        servicio.guardarEmpleado(empleado);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
        return "redirect:/empleados";
    }


    // ***** MODIFICAR REGISTROS ***** //

    @GetMapping("/{id}/editar/empleado")
    public String mostrarFormularioDeEditarEmpl(@PathVariable Long id, Model modelo) {
        Empleado empleado = servicio.obtenerEmpleadoId(id);
        modelo.addAttribute("empleados", empleado);
        return "editarRegEmpl";
    }


    @PostMapping("/{id}/editar/empleado")
    public String actualizarEmpl(@PathVariable Long id, @ModelAttribute("empleados") Empleado empleado, Model modelo) {
        Empleado emplActual = servicio.obtenerEmpleadoId(id);
        emplActual.setId(id);
        emplActual.setNombre(empleado.getNombre());
        emplActual.setCorreo(empleado.getCorreo());
        emplActual.setRole(empleado.getRole());
        emplActual.setFechaCreacion(empleado.getFechaCreacion());
        servicio.guardarEmpleado(emplActual);
        return "redirect:/empleados";
    }


    // ***** ELIMINAR REGISTRO ***** //

    @PostMapping("/{id}/eliminar/empleado")
    public String eliminarEmpleado(@PathVariable Long id,RedirectAttributes redirect) {
        Empleado empleado = servicio.obtenerEmpleadoId(id);
        servicio.eliminarEmpleado(empleado.getId());
        redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
        return "redirect:/empleados";
    }





}
