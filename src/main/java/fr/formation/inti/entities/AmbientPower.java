package fr.formation.inti.entities;
// Generated 29 avr. 2019 09:45:24 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * AmbientPower generated by hbm2java
 */
@Entity
@Table(name = "ambient_power", catalog = "urbanproject")
public class AmbientPower implements java.io.Serializable, IAllTypeEntities {

	private int id;
	@JsonIgnore
	private Users users;
	@NotEmpty
	private String latitude;
	@NotEmpty
	private String longitude;
	private Date datecreation;
	private Integer votepos;
	private Integer voteneg;
	@NotEmpty
	private String titre;
	@NotEmpty
	private String descriptif;
	private String photopath;
	private String ref;
	@NotEmpty
	private String ideeamelioration;
	@Min(1)
	@Max(10)
	private Integer intensiteressentie;
	@JsonIgnore
	private Set<Comment> comments = new HashSet<Comment>(0);

	public AmbientPower() {
	}

	public AmbientPower(int id, Users users, String latitude, String longitude, Date datecreation, String titre,
			String descriptif) {
		this.id = id;
		this.users = users;
		this.latitude = latitude;
		this.longitude = longitude;
		this.datecreation = datecreation;
		this.titre = titre;
		this.descriptif = descriptif;
	}

	public AmbientPower(int id, Users users, String latitude, String longitude, Date datecreation, Integer votepos,
			Integer voteneg, String titre, String descriptif, String photopath, String ref, String ideeamelioration,
			Integer intensiteressentie, Set<Comment> comments) {
		this.id = id;
		this.users = users;
		this.latitude = latitude;
		this.longitude = longitude;
		this.datecreation = datecreation;
		this.votepos = votepos;
		this.voteneg = voteneg;
		this.titre = titre;
		this.descriptif = descriptif;
		this.photopath = photopath;
		this.ref = ref;
		this.ideeamelioration = ideeamelioration;
		this.intensiteressentie = intensiteressentie;
		this.comments = comments;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_idusers", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "latitude", nullable = false, length = 45)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false, length = 45)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datecreation", nullable = false, length = 10)
	public Date getDatecreation() {
		return this.datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	@Column(name = "votepos")
	public Integer getVotepos() {
		return this.votepos;
	}

	public void setVotepos(Integer votepos) {
		this.votepos = votepos;
	}

	@Column(name = "voteneg")
	public Integer getVoteneg() {
		return this.voteneg;
	}

	public void setVoteneg(Integer voteneg) {
		this.voteneg = voteneg;
	}

	@Column(name = "titre", nullable = false)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "descriptif", nullable = false, length = 16777215)
	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	@Column(name = "photopath")
	public String getPhotopath() {
		return this.photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	@Column(name = "ref", length = 45)
	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Column(name = "ideeamelioration", length = 16777215)
	public String getIdeeamelioration() {
		return this.ideeamelioration;
	}

	public void setIdeeamelioration(String ideeamelioration) {
		this.ideeamelioration = ideeamelioration;
	}

	@Column(name = "intensiteressentie")
	public Integer getIntensiteressentie() {
		return this.intensiteressentie;
	}

	public void setIntensiteressentie(Integer intensiteressentie) {
		this.intensiteressentie = intensiteressentie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ambientPower")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
