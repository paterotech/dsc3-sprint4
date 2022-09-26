package edu.udea.main.servicios;

import edu.udea.main.entidades.Perfil;
import edu.udea.main.repositorios.IPerfilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPerfil {

    @Autowired
    private IPerfilRepo repositorio;

    public List<Perfil> listarPerfil(){
        return repositorio.findAll();
    }

    public void guardarPerfil(Perfil perfil) {
        repositorio.save(perfil);
    }

    public Perfil obtenerPerfilId(String id) {
        return repositorio.findById(id).get();
    }

    public void eliminarPerfil(String id) {
        repositorio.deleteById(id);
    }
}
