package test.hql;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Serwis",schema = "test10")
public class Serwis {
	
	@Id
	@SequenceGenerator(name = "idSerwisu_seq", sequenceName = "test10.idSerwisu_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idSerwisu_seq")
	private Long idSerwisu;
	
	@Column(name = "nazwaSamochodu")
	private String nazwaSamochodu;
	@Column(name = "przebieg")
	private Double przebieg;
	@Column(name = "dokonalPrzegladu")
	private String dokonalPrzegladu;
	
	@ManyToOne
	private Samochod autko ;
	
	
	public Samochod getAutko() {
		return autko;
	}
	public void setAutko(Samochod autko) {
		this.autko = autko;
	}
	public Long getIdSerwisu() {
		return idSerwisu;
	}
	public void setIdSerwisu(Long idSerwisu) {
		this.idSerwisu = idSerwisu;
	}
	public String getNazwaSamochodu() {
		return nazwaSamochodu;
	}
	public void setNazwaSamochodu(String nazwaSamochodu) {
		this.nazwaSamochodu = nazwaSamochodu;
	}
	public Double getPrzebieg() {
		return przebieg;
	}
	public void setPrzebieg(Double przebieg) {
		this.przebieg = przebieg;
	}
	public String getDokonalPrzegladu() {
		return dokonalPrzegladu;
	}
	public void setDokonalPrzegladu(String dokonalPrzegladu) {
		this.dokonalPrzegladu = dokonalPrzegladu;
	}
	
}
