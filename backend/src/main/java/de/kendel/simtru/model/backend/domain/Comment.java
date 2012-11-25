package de.kendel.simtru.model.backend.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="simtru_user")
public class Comment extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -5633684593452766951L;
	
	@ManyToOne
	private Discussion discussion;
	private String text;
	
	@OneToOne
	private Image image;
	
	public Comment()
	{
	}
	
	public Comment(Long id)
	{
		setId(id);
	}
	
	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}