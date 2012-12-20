package de.kendel.simtru.model.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="image")
public class Image extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -3930067151642925862L;

	@Lob
	private byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
