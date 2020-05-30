package com.mediaItem.media.Item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaItem.media.Item.repo.MediaItemRepo;

@Service
public class MediaItemService {
	MediaItemRepo mediaItemRepo;
	
	@Autowired
	MediaItemService(MediaItemRepo mediaItemRepo) {
		this.mediaItemRepo = mediaItemRepo;
	}
}
