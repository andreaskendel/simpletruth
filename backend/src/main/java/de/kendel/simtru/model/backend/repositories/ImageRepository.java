package de.kendel.simtru.model.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kendel.simtru.model.backend.domain.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
