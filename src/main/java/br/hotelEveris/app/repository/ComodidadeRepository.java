package br.hotelEveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hotelEveris.app.model.Comodidade;

@Repository
public interface ComodidadeRepository extends JpaRepository<Comodidade, Long>{

}