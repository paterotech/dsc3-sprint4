package edu.udea.main.repositorios;

import edu.udea.main.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepo extends JpaRepository<Empresa, Long> {

}
