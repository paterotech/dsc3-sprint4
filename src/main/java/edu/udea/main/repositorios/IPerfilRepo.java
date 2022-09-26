package edu.udea.main.repositorios;

import edu.udea.main.entidades.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepo extends JpaRepository<Perfil, String> {

}
