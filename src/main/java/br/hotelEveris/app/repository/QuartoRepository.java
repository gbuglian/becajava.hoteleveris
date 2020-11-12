package br.hotelEveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hotelEveris.app.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long>{

}
