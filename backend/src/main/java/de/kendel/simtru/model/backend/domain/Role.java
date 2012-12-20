package de.kendel.simtru.model.backend.domain;

public enum Role {
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN");
	
	private String name;
	
	private Role(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
