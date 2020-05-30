package com.mediaItem.media.Item.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mediaItem.media.Item.entity.MediaCategory;
import com.mediaItem.media.Item.entity.MediaMedium;

@RepositoryRestResource(exported=false)
public interface MediaCategoryRepo extends CrudRepository<MediaCategory, String>{
	Optional<MediaCategory> findById(String id);
}
