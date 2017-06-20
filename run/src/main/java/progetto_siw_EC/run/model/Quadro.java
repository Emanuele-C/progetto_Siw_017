package progetto_siw_EC.run.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Quadro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo;
	@NotNull
	private Integer anno;
	@NotNull
	private String tecnica;
	@NotNull
	private float lunghezza;
	@NotNull
	private String luUnita;
	@NotNull
	private String laUnita;
	@NotNull
	private float larghezza;
	@ManyToOne
	private Autore autore;
	
	protected Quadro() {}
	
	public Quadro(String titolo, String tecnica, int anno, float lunghezza, float larghezza,String luUnita, String laUnita, Autore autore){
		this.titolo=titolo;
		this.tecnica=tecnica;
		this.anno=anno;
		this.lunghezza=lunghezza;
		this.larghezza=larghezza;
		this.luUnita= luUnita;
		this.autore=autore;
	}
	public Long getId(){
		return this.id;
	}

	public String getTitolo(){
		return this.titolo;
	}
	public void setTitolo(String titolo){
		this.titolo=titolo;	
	}
	public Integer getAnno(){
		return this.anno;
	}
	public void setAnno(Integer anno){
		this.anno=anno;
		
	}
	public String getTecnica(){
		return this.tecnica;
	}
	public void setTecnica(String tecnica){
		this.tecnica=tecnica;
		
	}
	public Float getLunghezza(){
		return this.lunghezza;
	}
	public void setLunghezza(float lunghezza){
		this.lunghezza=lunghezza;	
	}
	public void setLuUnita(String luUnita){
		this.luUnita=luUnita;
	}
	public void setLaUnita(String laUnita){
		this.laUnita=laUnita;
	}
	public Float getLarghezza(){
		return this.larghezza;
	}
	public void setLarghezza(float larghezza){
		this.larghezza= larghezza;
	}
	public Autore getAutore(){
		return this.autore;
	}
	public void setAutore(Autore autore){
		this.autore=autore;
		
	}
}
