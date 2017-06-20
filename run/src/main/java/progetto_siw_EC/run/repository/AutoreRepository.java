package progetto_siw_EC.run.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import progetto_siw_EC.run.model.Autore;


public interface AutoreRepository extends CrudRepository<Autore,Long>{
	List<Autore> findByNome(String Nome);
	List<Autore> findByCognome(String cognome);
}
