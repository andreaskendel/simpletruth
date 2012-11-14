package de.kendel.simtru.model.backend.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="simtru_user")
public class Comment extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -5633684593452766951L;
	
	@ManyToOne
	private ImageThread thread;
	private String text;
	private byte[] image;
	
	public ImageThread getThread() {
		return thread;
	}
	
	public void setThread(ImageThread thread) {
		this.thread = thread;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}