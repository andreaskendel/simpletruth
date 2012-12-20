package de.kendel.simtru.model.backend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.IndexColumn;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="discussion")
public class Discussion extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -6170773589649899169L;
	
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
