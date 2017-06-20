package progetto_siw_EC.run.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import progetto_siw_EC.run.model.Quadro;


public interface QuadroRepository extends CrudRepository<Quadro, Long> {
	
	List <Quadro> findByTitolo(String titolo);
	

}
