package edu.udea.main.controladores;

import edu.udea.main.entidades.Empleado;
import edu.udea.main.entidades.Perfil;
import edu.udea.main.servicios.ServicioPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControladorPerfil {

    @Autowired
    private ServicioPerfil servicioPerfil;

    @GetMapping({"/perfiles"})
    public String listarPerfil(Model modelo) {
        List<Perfil> perfils = servicioPerfil.listarPerfil();
        modelo.addAttribute("perfils", perfils);
        return "perfiles";
    }

}
