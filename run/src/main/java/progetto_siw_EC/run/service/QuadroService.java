package progetto_siw_EC.run.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto_siw_EC.run.model.Autore;
import progetto_siw_EC.run.model.Quadro;
import progetto_siw_EC.run.repository.QuadroRepository;

@Service
public class QuadroService {

	 @Autowired
	    private QuadroRepository QuadroRepository; 

	    public Iterable<Quadro> findAll() {
	        return this.QuadroRepository.findAll();
	    }

	    @Transactional
	    public void add(final Quadro quadro) {
	        this.QuadroRepository.save(quadro);
	    }

		public Quadro findbyId(Long id) {
			return this.QuadroRepository.findOne(id);
		}
		
		public void cancella(Long id) {
			this.QuadroRepository.delete(id);
		}	
		public Autore findAutoreOpera(long id ){
			return this.findbyId(id).getAutore();
		}

}
