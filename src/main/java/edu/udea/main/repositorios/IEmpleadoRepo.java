package edu.udea.main.repositorios;

import edu.udea.main.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepo extends JpaRepository<Empleado, Long> {
}
