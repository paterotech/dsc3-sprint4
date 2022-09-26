package edu.udea.main.servicios;

import edu.udea.main.entidades.Movimiento;
import edu.udea.main.repositorios.IMovimientoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMovimiento {

    @Autowired
    private IMovimientoRepo movimientoRepo;

    public List<Movimiento> listarMovimiento(){
        return movimientoRepo.findAll();
    }

    public void guardarMovimiento(Movimiento movimiento) {
        movimientoRepo.save(movimiento);
    }

    public Movimiento obtenerMovimiento(Long id) {
        return movimientoRepo.findById(id).get();

    }

    public void eliminarMovimiento(Long id) {
        movimientoRepo.deleteById(id);
    }

}
