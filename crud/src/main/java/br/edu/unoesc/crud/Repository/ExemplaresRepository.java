package br.edu.unoesc.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.crud.model.Exemplares;

public interface ExemplaresRepository extends JpaRepository<Exemplares, Long>{

	@Query("select e from Exemplares e where e.id <= 5")
	List<Exemplares> cincoPrimeiros();
	
}
