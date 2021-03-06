package test.hql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "Samochod",schema = "test10")
@NamedQueries({
    @NamedQuery(name = "Samochody", query = "select nazwaSamochody from Samochod"),
    @NamedQuery(name = "Przebieg", query = "select przebieg from Samochod where przebieg > 1000.00"),
})
public class Samochod {
	
	@Id
	@SequenceGenerator(name = "idSamochodu_seq", sequenceName = "test10.idSamochodu_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idSamochodu_seq")
	private Long idSamochodu;
	@Column(name = "nazwaSamochody")
	private String nazwaSamochody;
	@Column(name = "przebieg")
	private Double przebieg;
	
	@OneToOne
	private UzytkownikDane dane;

	
	@OneToMany
	@JoinColumn(name = "idSamochodu")
	private List<Serwis> serwiss = new ArrayList<Serwis>();
	
	
	public Double getPrzebieg() {
		return przebieg;
	}
	public void setPrzebieg(Double przebieg) {
		this.przebieg = przebieg;
	}
	public Long getIdSamochodu() {
		return idSamochodu;
	}
	public void setIdSamochodu(Long idSamochodu) {
		this.idSamochodu = idSamochodu;
	}
	public String getNazwaSamochodu() {
		return nazwaSamochody;
	}
	public void setNazwaSamochodu(String nazwaSamochodu) {
		this.nazwaSamochody = nazwaSamochodu;
	}
}
