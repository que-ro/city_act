package fr.formation.inti.entities;
<<<<<<< HEAD
// Generated 25 avr. 2019 14:51:10 by Hibernate Tools 5.1.10.Final
=======
// Generated 25 avr. 2019 14:28:46 by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;
>>>>>>> refs/heads/qtn

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
<<<<<<< HEAD
import static javax.persistence.GenerationType.IDENTITY;
=======
>>>>>>> refs/heads/qtn
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * AmbientPower generated by hbm2java
 */
@Entity
@Table(name = "ambient_power", catalog = "urbanproject")
public class AmbientPower implements java.io.Serializable {

	private Integer idambientpower;
<<<<<<< HEAD
=======
	@NotEmpty
>>>>>>> refs/heads/qtn
	private String latitude;
	@NotEmpty
	private String longitude;
<<<<<<< HEAD
	private Date datecreation;
	private Integer votepos;
	private Integer voteneg;
=======
	private Date dateCreation;
	private Integer votepos;
	private Integer voteneg;
	@NotEmpty
>>>>>>> refs/heads/qtn
	private String titre;
	@NotEmpty
	private String descriptif;
	private String photopath;
	private String ref;
<<<<<<< HEAD
	private String ideeamelioration;
=======
	@NotEmpty
	private String ideeamelioration;
	@Min(1)
	@Max(10)
>>>>>>> refs/heads/qtn
	private Integer intensiteressentie;
	private Set<Comment> comments = new HashSet<Comment>(0);

	public AmbientPower() {
	}

<<<<<<< HEAD
	public AmbientPower(String latitude, String longitude, Date datecreation, String titre, String descriptif) {
=======
	public AmbientPower(String latitude, String longitude, Date dateCreation, String titre, String descriptif) {
>>>>>>> refs/heads/qtn
		this.latitude = latitude;
		this.longitude = longitude;
		this.datecreation = datecreation;
		this.titre = titre;
		this.descriptif = descriptif;
	}

<<<<<<< HEAD
	public AmbientPower(String latitude, String longitude, Date datecreation, Integer votepos, Integer voteneg,
=======
	public AmbientPower(String latitude, String longitude, Date dateCreation, Integer votepos, Integer voteneg,
>>>>>>> refs/heads/qtn
			String titre, String descriptif, String photopath, String ref, String ideeamelioration,
			Integer intensiteressentie, Set<Comment> comments) {
		this.latitude = latitude;
		this.longitude = longitude;
<<<<<<< HEAD
		this.datecreation = datecreation;
=======
		this.dateCreation = dateCreation;
>>>>>>> refs/heads/qtn
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
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idambientpower", unique = true, nullable = false)
	public Integer getIdambientpower() {
		return this.idambientpower;
	}

	public void setIdambientpower(Integer idambientpower) {
		this.idambientpower = idambientpower;
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
<<<<<<< HEAD
	public Date getDatecreation() {
		return this.datecreation;
=======
	public Date getDateCreation() {
		return this.dateCreation;
>>>>>>> refs/heads/qtn
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
