package edu.udea.main.servicios;

import edu.udea.main.entidades.Empresa;
import edu.udea.main.repositorios.IEmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpresa {

    @Autowired
    private IEmpresaRepo repositorio;

    public List<Empresa> listarEmpresa(){
        return repositorio.findAll();
    }

    public void guardarEmpresa(Empresa empresa) {
        repositorio.save(empresa);
    }

    public Empresa obtenerEmpresa(Long id) {
        return repositorio.findById(id).get();
    }

    public void eliminarEmpresa(Long id) {
        repositorio.deleteById(id);
    }

}
