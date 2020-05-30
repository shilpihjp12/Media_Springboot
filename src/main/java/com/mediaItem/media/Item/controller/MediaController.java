package com.mediaItem.media.Item.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mediaItem.media.Item.entity.MediaCategory;
import com.mediaItem.media.Item.entity.MediaItem;
import com.mediaItem.media.Item.entity.MediaMedium;
import com.mediaItem.media.Item.repo.MediaCategoryRepo;
import com.mediaItem.media.Item.repo.MediaItemRepo;
import com.mediaItem.media.Item.repo.MediaMediumRepo;

@RequestMapping(value = "/media")
@RestController
public class MediaController {
	MediaItemRepo mediaItemRepo;
	MediaMediumRepo mdiaMediumRepo;
	MediaCategoryRepo mediaCategoryRepo;
	
	@Autowired
	public MediaController(MediaMediumRepo mdiaMediumRepo, MediaItemRepo mediaItemRepo, MediaCategoryRepo mediaCategoryRepo) {
		this.mdiaMediumRepo = mdiaMediumRepo;
		this.mediaItemRepo =  mediaItemRepo;
		this.mediaCategoryRepo = mediaCategoryRepo;
	}
	
	@PostMapping("/savemedia")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Iterable<MediaItem>> saveMediaItem(@RequestBody MediaItem mediaItem) {
		Optional<MediaItem> media = mediaItemRepo.findByName(mediaItem.getName());
		if(media.isPresent()) {
			MediaItem mediaUpdate = new MediaItem(media.get().getId(), mediaItem.getName(), null, mediaItem.getMedium(),
					null, mediaItem.getCategory(), mediaItem.getYear(), mediaItem.getWatchedOn(), mediaItem.isFavorite());
			mediaItemRepo.save(mediaUpdate);
		} else {
			mediaItemRepo.save(mediaItem);
		}
		return new ResponseEntity<>(mediaItemRepo.findAll(), HttpStatus.CREATED);
	}
	
	@GetMapping("/getmedia")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<MediaItem> getAllMediaItem() {
		return mediaItemRepo.findAll();
	}
	
	@GetMapping("/getmediaByMedium")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<MediaItem> getAllMediaItemByMedium(@RequestParam(value="medium") String medium) {
		return mediaItemRepo.findByMedium(medium);
	}
	
	@GetMapping("/getmediabyid")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MediaItem> getAllMediaItem(@RequestParam(value="id") String id) {
		Optional<MediaItem> mediaItem = mediaItemRepo.findById(id);
		if(!mediaItem.isPresent()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<MediaItem>(mediaItem.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletemediabyid")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Iterable<MediaItem>> deleteMediaItem(@RequestParam(value="id") String id) {
		Optional<MediaItem> mediaItem = mediaItemRepo.findById(id);
		if(mediaItem.isPresent()) {
			mediaItemRepo.deleteById(id);
		}
		return new ResponseEntity<>(mediaItemRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getCategory")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<MediaCategory> getAllMediaCategory() {
		return mediaCategoryRepo.findAll();
	}
	
	@GetMapping("/getMedium")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<MediaMedium> getAllMediaMedium() {
		return mdiaMediumRepo.findAll();
	}
}
