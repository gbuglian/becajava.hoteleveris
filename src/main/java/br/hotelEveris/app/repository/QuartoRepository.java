package br.hotelEveris.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.hotelEveris.app.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long>{
	
	Optional<Quarto> findByNumQuarto(int NumQuarto);
	
	@Query(value = "SELECT *FROM Quarto WHERE IdTipoQuarto = :id" , nativeQuery = true)     
	
	List<Quarto> findByTipoQuartos(@Param("id") Long id);
}
