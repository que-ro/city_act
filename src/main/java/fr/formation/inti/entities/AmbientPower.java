package fr.formation.inti.entities;
// Generated 24 avr. 2019 15:57:26 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AmbientPower generated by hbm2java
 */
@Entity
@Table(name = "ambient_power", catalog = "urbanproject")
public class AmbientPower implements java.io.Serializable {

	private int idambientPower;
	private String latitude;
	private String longitude;
	private Date dateCreation;
	private Integer votePos;
	private Integer voteNeg;
	private String titre;
	private String descriptif;
	private String photoPath;
	private String ref;
	private String ideeAmelioration;
	private Integer intensiteRessentie;
	private Set<Comment> comments = new HashSet<Comment>(0);

	public AmbientPower() {
	}

	public AmbientPower(int idambientPower, String latitude, String longitude, Date dateCreation, String titre,
			String descriptif) {
		this.idambientPower = idambientPower;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.descriptif = descriptif;
	}

	public AmbientPower(int idambientPower, String latitude, String longitude, Date dateCreation, Integer votePos,
			Integer voteNeg, String titre, String descriptif, String photoPath, String ref, String ideeAmelioration,
			Integer intensiteRessentie, Set<Comment> comments) {
		this.idambientPower = idambientPower;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateCreation = dateCreation;
		this.votePos = votePos;
		this.voteNeg = voteNeg;
		this.titre = titre;
		this.descriptif = descriptif;
		this.photoPath = photoPath;
		this.ref = ref;
		this.ideeAmelioration = ideeAmelioration;
		this.intensiteRessentie = intensiteRessentie;
		this.comments = comments;
	}

	@Id

	@Column(name = "idambient_power", unique = true, nullable = false)
	public int getIdambientPower() {
		return this.idambientPower;
	}

	public void setIdambientPower(int idambientPower) {
		this.idambientPower = idambientPower;
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
	@Column(name = "date_creation", nullable = false, length = 10)
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Column(name = "vote_pos")
	public Integer getVotePos() {
		return this.votePos;
	}

	public void setVotePos(Integer votePos) {
		this.votePos = votePos;
	}

	@Column(name = "vote_neg")
	public Integer getVoteNeg() {
		return this.voteNeg;
	}

	public void setVoteNeg(Integer voteNeg) {
		this.voteNeg = voteNeg;
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

	@Column(name = "photo_path")
	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Column(name = "ref", length = 45)
	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Column(name = "idee_amelioration", length = 16777215)
	public String getIdeeAmelioration() {
		return this.ideeAmelioration;
	}

	public void setIdeeAmelioration(String ideeAmelioration) {
		this.ideeAmelioration = ideeAmelioration;
	}

	@Column(name = "intensite_ressentie")
	public Integer getIntensiteRessentie() {
		return this.intensiteRessentie;
	}

	public void setIntensiteRessentie(Integer intensiteRessentie) {
		this.intensiteRessentie = intensiteRessentie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ambientPower")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
