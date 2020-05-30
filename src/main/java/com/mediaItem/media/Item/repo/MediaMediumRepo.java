package com.mediaItem.media.Item.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mediaItem.media.Item.entity.MediaMedium;

@RepositoryRestResource(exported=false)
public interface MediaMediumRepo extends CrudRepository<MediaMedium, String>{
	
}
