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
	public class Amministratore {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		@NotNull
		@Size(min=1)
		private String username;
		@NotNull
		@Size(min=1)
		private String password;
		
		
		
		public Amministratore(){
			
		}
		public Amministratore(String username,String passowrd){
			this.username=username;
			this.password=password;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername(){
			return this.username;
		}
		public void setUsername(String username){
			this.username=username;	
		}
		public String getPassword(){
			return this.password;
		}
		public void setPassword(String password){
			this.password=password;
			
		}
	}