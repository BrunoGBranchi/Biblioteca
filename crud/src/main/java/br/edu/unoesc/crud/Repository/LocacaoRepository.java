package br.edu.unoesc.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.crud.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
