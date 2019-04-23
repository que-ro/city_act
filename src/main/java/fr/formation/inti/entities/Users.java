package fr.formation.inti.entities;
// Generated 18 avr. 2019 16:14:00 by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "urbanproject")
public class Users implements java.io.Serializable {

	private Integer idusers;
	private String mail;
	@NotNull
    @Size(min=2, max=40)
	private String pseudo;
	@NotNull
    @Size(min=8)
	private String password;
	@NotNull
	@Size(min=2)
	private String street;
	@NotNull
	@Size(min=2)
	private String city;
	@NotNull
	private Integer zipcode;
	@NotNull
	@Size(min=2)
	private String country;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	@Size(min=2)
	@NotNull
	private String firstname;
	@NotNull
	@Size(min=2)
	private String lastname;
	private Set<Comment> comments = new HashSet<Comment>(0);

	public Users() {
	}

	public Users(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public Users(String mail, String pseudo, String password, String street, String city, Integer zipcode,
			String country, Date birthdate, String firstname, String lastname, Set<Comment> comments) {
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.birthdate = birthdate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.comments = comments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusers", unique = true, nullable = false)
	public Integer getIdusers() {
		return this.idusers;
	}

	public void setIdusers(Integer idusers) {
		this.idusers = idusers;
	}
	
	@Column(name = "mail", nullable = false, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "pseudo", length = 45)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "street")
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zipcode")
	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 10)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
