package test.hql;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Uzytkownicy",query ="select userName from UzytkownikDane")
@Table(name="DaneUzytkownika",schema = "test10")
public class UzytkownikDane {
	
	@Id
	@SequenceGenerator(name = "userID_seq", sequenceName = "test10.userID_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userID_seq")
	private Long userID;
	
	@Column(name ="UserName")
	private String userName;
	
	@OneToOne(mappedBy = "dane")
	@JoinColumn
	private Samochod samochod;
	
	public Samochod getSamochod() {
		return samochod;
	}
	public void setSamochod(Samochod samochod) {
		this.samochod = samochod;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
