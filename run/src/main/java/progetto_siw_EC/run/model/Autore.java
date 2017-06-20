package progetto_siw_EC.run.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.List;
	
	@Entity
	public class Autore {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		@NotNull
		@Size(min=1)
		private String nome;
		@NotNull
		@Size(min=1)
		private String cognome;
		@NotNull
		@Size(min=1)
		private String nazionalita;
		
		@Temporal(TemporalType.DATE)
		@NotNull
		private Date dataNascita;
		
		@Temporal(TemporalType.DATE) //è possibile non sia ancora morto
		private Date dataMorte;
		
		@OneToMany(mappedBy="autore")
		@Cascade({CascadeType.DELETE})
		private List<Quadro> quadri;
		
		public Autore(){
			
		}
		public Autore(String nome,String cognome,String nazionalita,Date dataNascita){
			this.nome=nome;
			this.cognome=cognome;
			this.nazionalita=nazionalita;
			this.dataNascita=dataNascita;
		}

		public Autore(String nome,String cognome,String nazionalita,Date dataNascita,Date dataMorte){
			this.nome=nome;
			this.cognome=cognome;
			this.nazionalita=nazionalita;
			this.dataNascita=dataNascita;
			this.dataMorte=dataMorte;
		}
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome(){
			return this.nome;
		}
		public void setNome(String nome){
			this.nome=nome;	
		}
		public String getCognome(){
			return this.cognome;
		}
		public void setCognome(String cognome){
			this.cognome=cognome;
			
		}
		public String getNazionalita(){
			return this.nazionalita;
		}
		public void setNazionalita(String nazionalita){
			this.nazionalita=nazionalita;
			
		}
		public Date getDataNascita(){
			return this.dataNascita;
		}
		public void setDataNascita(Date dataNascita){
			this.dataNascita=dataNascita;
			
		}
		public Date getDataMorte(){
			return this.dataNascita;
		}
		public void setDataMorte(Date dataMorte){
			this.dataMorte=dataMorte;	
		}
		
		public List<Quadro> getListaQuadri(){
			return this.quadri;
		}
		public void setListaQuadri(List<Quadro> quadri){
			this.quadri=quadri;
		}
	}
