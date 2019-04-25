package fr.formation.inti.entities;
<<<<<<< HEAD
// Generated 25 avr. 2019 14:51:10 by Hibernate Tools 5.1.10.Final
=======
// Generated 25 avr. 2019 14:28:46 by Hibernate Tools 5.1.10.Final
>>>>>>> refs/heads/qtn

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SpringSession generated by hbm2java
 */
@Entity
@Table(name = "spring_session", catalog = "urbanproject", uniqueConstraints = @UniqueConstraint(columnNames = "SESSION_ID"))
public class SpringSession implements java.io.Serializable {

	private String primaryId;
	private String sessionId;
	private long creationTime;
	private long lastAccessTime;
	private int maxInactiveInterval;
	private long expiryTime;
	private String principalName;
	private Set<SpringSessionAttributes> springSessionAttributeses = new HashSet<SpringSessionAttributes>(0);

	public SpringSession() {
	}

	public SpringSession(String primaryId, String sessionId, long creationTime, long lastAccessTime,
			int maxInactiveInterval, long expiryTime) {
		this.primaryId = primaryId;
		this.sessionId = sessionId;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.maxInactiveInterval = maxInactiveInterval;
		this.expiryTime = expiryTime;
	}

	public SpringSession(String primaryId, String sessionId, long creationTime, long lastAccessTime,
			int maxInactiveInterval, long expiryTime, String principalName,
			Set<SpringSessionAttributes> springSessionAttributeses) {
		this.primaryId = primaryId;
		this.sessionId = sessionId;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.maxInactiveInterval = maxInactiveInterval;
		this.expiryTime = expiryTime;
		this.principalName = principalName;
		this.springSessionAttributeses = springSessionAttributeses;
	}

	@Id

	@Column(name = "PRIMARY_ID", unique = true, nullable = false, length = 36)
	public String getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	@Column(name = "SESSION_ID", unique = true, nullable = false, length = 36)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "CREATION_TIME", nullable = false)
	public long getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	@Column(name = "LAST_ACCESS_TIME", nullable = false)
	public long getLastAccessTime() {
		return this.lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	@Column(name = "MAX_INACTIVE_INTERVAL", nullable = false)
	public int getMaxInactiveInterval() {
		return this.maxInactiveInterval;
	}

	public void setMaxInactiveInterval(int maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}

	@Column(name = "EXPIRY_TIME", nullable = false)
	public long getExpiryTime() {
		return this.expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	@Column(name = "PRINCIPAL_NAME", length = 100)
	public String getPrincipalName() {
		return this.principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "springSession")
	public Set<SpringSessionAttributes> getSpringSessionAttributeses() {
		return this.springSessionAttributeses;
	}

	public void setSpringSessionAttributeses(Set<SpringSessionAttributes> springSessionAttributeses) {
		this.springSessionAttributeses = springSessionAttributeses;
	}

}
