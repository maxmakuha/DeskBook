package test.makuha.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NamedQueries({ @NamedQuery(name = Person.getAllContacts, query = "SELECT person.idperson, person.fio, person.number FROM Person person"),
		@NamedQuery(name = Person.getContactById, query = "SELECT person.idperson, person.fio, person.number FROM Person person WHERE person.idperson = :idperson"), })
public class Person {

	public static final String getAllContacts = "Person.getAllContacts";
	public static final String getContactById = "Person.getContactById";

	@Id
	@GeneratedValue
	@Column(name = "idperson")
	private int idperson;

	@Column(name = "fio")
	private String fio;

	@Column(name = "number")
	private String number;

	public Person() {
	}

	public Person(int idperson, String fio, String number) {
		this.idperson = idperson;
		this.fio = fio;
		this.number = number;
	}

	public int getIdperson() {
		return idperson;
	}

	public void setIdperson(int idperson) {
		this.idperson = idperson;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
