package org.giveUp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.giveUp.domain.Dependencia;
import org.giveUp.domain.UsuarioDependencia;

@Repository
public interface RepositoryUsuarioDependencia extends JpaRepository<UsuarioDependencia, Long> {

}



