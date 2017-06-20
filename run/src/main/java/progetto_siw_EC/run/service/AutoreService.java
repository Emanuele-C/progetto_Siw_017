package progetto_siw_EC.run.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto_siw_EC.run.model.Quadro;
import progetto_siw_EC.run.model.Autore;
import progetto_siw_EC.run.repository.AutoreRepository;

@Service
public class AutoreService  {

	@Autowired
    private AutoreRepository autoreRepository; 
	
	 public Iterable<Autore> findAll() {
	        return this.autoreRepository.findAll();
	    }

	    @Transactional
	    public void add(final Autore autore) {
	        this.autoreRepository.save(autore);
	    }

		public Autore findbyId(Long id) {
			return this.autoreRepository.findOne(id);
		}
		
		public void cancella(Long id) {
			this.autoreRepository.delete(id);
		}	
		
		public Iterable<Quadro> findAllQuadroAutore(Long id){
			Autore a = this.autoreRepository.findOne(id);
			return a.getListaQuadri();
		}
		


}
