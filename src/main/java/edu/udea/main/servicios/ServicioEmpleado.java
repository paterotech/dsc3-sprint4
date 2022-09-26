package edu.udea.main.servicios;

import edu.udea.main.entidades.Empleado;
import edu.udea.main.repositorios.IEmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {

    @Autowired
    private IEmpleadoRepo repositorio;

    public List<Empleado> listarEmpleado(){
        return repositorio.findAll();
    }

    public void guardarEmpleado(Empleado empleado) {
        repositorio.save(empleado);
    }

    public Empleado obtenerEmpleadoId(Long id) {
        return repositorio.findById(id).get();
    }

    public void eliminarEmpleado(Long id) {
        repositorio.deleteById(id);
    }
}
