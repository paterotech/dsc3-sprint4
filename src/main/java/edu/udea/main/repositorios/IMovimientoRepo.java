package edu.udea.main.repositorios;

import edu.udea.main.entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepo extends JpaRepository<Movimiento, Long> {
}
