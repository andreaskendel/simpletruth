package de.kendel.simtru.model.backend.domain;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="simtru_image")
public class Image extends AbstractAuditable<User, Long>{
	private static final long serialVersionUID = -3930067151642925862L;

	private byte[] bytes;
	
	@Transient
	private File tmpFile;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public File getTmpFile() {
		return tmpFile;
	}

	public void setTmpFile(File tmpFile) {
		this.tmpFile = tmpFile;
	}
}
