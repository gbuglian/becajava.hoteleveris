package br.hotelEveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hotelEveris.app.model.QuartoComodidade;

@Repository
public interface QuartoComodidadeRepository extends JpaRepository<QuartoComodidade, Long> {

}
