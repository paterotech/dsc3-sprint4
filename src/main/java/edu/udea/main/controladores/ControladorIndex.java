package edu.udea.main.controladores;

import edu.udea.main.entidades.Usuario;
import edu.udea.main.servicios.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndex {


    @Autowired
    private GestorUsuarioInterface gestorUsuario;

    @GetMapping("/")
    public String bienvenida() {
        return "bienvenida";
    }


    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario",new Usuario());
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("usuarios",gestorUsuario.getUsuarios());
        return "index";
    }

//    @GetMapping("/index")
//    public String index() {
//        return "index";
//    }

}
