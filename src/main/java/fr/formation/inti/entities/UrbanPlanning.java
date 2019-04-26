package fr.formation.inti.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UrbanPlanning generated by hbm2java
 */
@Entity
@Table(name = "urban_planning", catalog = "urbanproject")
public class UrbanPlanning implements java.io.Serializable, IAllTypeEntities {

	private Integer idplanningproposal;
	private String latitude;
	private String longitude;
	private Date datecreation;
	private String temporalite;
	private Integer votepos;
	private Integer voteneg;
	private String titre;
	private String descriptif;
	private String photopath;
	private String ref;
	public String benchmark;
	@JsonIgnore
	private Set<Comment> comments = new HashSet<Comment>(0);

	public UrbanPlanning() {
	}

	public UrbanPlanning(String latitude, String longitude, Date datecreation, String temporalite, String titre,
			String descriptif, String benchmark) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.datecreation = datecreation;
		this.temporalite = temporalite;
		this.titre = titre;
		this.descriptif = descriptif;
		this.benchmark = benchmark;
	}

	public UrbanPlanning(String latitude, String longitude, Date datecreation, String temporalite, Integer votepos,
			Integer voteneg, String titre, String descriptif, String photopath, String ref, String benchmark, Set<Comment> comments) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.datecreation = datecreation;
		this.temporalite = temporalite;
		this.votepos = votepos;
		this.voteneg = voteneg;
		this.titre = titre;
		this.descriptif = descriptif;
		this.photopath = photopath;
		this.ref = ref;
		this.comments = comments;
	}

	@Id

	@Column(name = "idplanningproposal", unique = true, nullable = false)
	public Integer getIdplanningproposal() {
		return this.idplanningproposal;
	}

	public void setIdplanningproposal(Integer idplanningproposal) {
		this.idplanningproposal = idplanningproposal;
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

	@Column(name = "temporalite", nullable = false)
	public String getTemporalite() {
		return this.temporalite;
	}

	public void setTemporalite(String temporalite) {
		this.temporalite = temporalite;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "urbanPlanning")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
	@Column(name = "benchmark", nullable = false, length = 16777215)
	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}


}
