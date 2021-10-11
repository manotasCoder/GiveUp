package org.giveUp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.giveUp.domain.Dependencia;

@Repository
public interface RepositoryDependencia extends JpaRepository<Dependencia, Long> {

}



