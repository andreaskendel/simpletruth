package de.kendel.simtru.model.backend.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="user")
public class User extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -732474548480408332L;
	
	private String displayName;
	private String username;
	private String password;
	@Transient
	private String newPassword;
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Role> roles;
	private Boolean isActive;
	
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
