package de.kendel.simtru.model.backend.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="simtru_user")
public class User extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -732474548480408332L;
	
	private String displayName;
	private String userName;
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
