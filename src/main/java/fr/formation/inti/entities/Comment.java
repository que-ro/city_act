package fr.formation.inti.entities;
// Generated 28 avr. 2019 12:04:06 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "comment", catalog = "urbanproject")
public class Comment implements java.io.Serializable {

	private int idComment;
	private AmbientPower ambientPower;
	private Signalement signalement;
	private UrbanPlanning urbanPlanning;
	private Users users;
	private Date date;
	private String text;

	public Comment() {
	}

	public Comment(int idComment, Users users) {
		this.idComment = idComment;
		this.users = users;
	}

	public Comment(int idComment, AmbientPower ambientPower, Signalement signalement, UrbanPlanning urbanPlanning,
			Users users, Date date, String text) {
		this.idComment = idComment;
		this.ambientPower = ambientPower;
		this.signalement = signalement;
		this.urbanPlanning = urbanPlanning;
		this.users = users;
		this.date = date;
		this.text = text;
	}

	@Id

	@Column(name = "idComment", unique = true, nullable = false)
	public int getIdComment() {
		return this.idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ambient_power_id")
	public AmbientPower getAmbientPower() {
		return this.ambientPower;
	}

	public void setAmbientPower(AmbientPower ambientPower) {
		this.ambientPower = ambientPower;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "signalement_id")
	public Signalement getSignalement() {
		return this.signalement;
	}

	public void setSignalement(Signalement signalement) {
		this.signalement = signalement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "urban_planning_id")
	public UrbanPlanning getUrbanPlanning() {
		return this.urbanPlanning;
	}

	public void setUrbanPlanning(UrbanPlanning urbanPlanning) {
		this.urbanPlanning = urbanPlanning;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_idusers", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "text", length = 16777215)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
