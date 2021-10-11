package org.giveUp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.giveUp.domain.Usuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{

}
