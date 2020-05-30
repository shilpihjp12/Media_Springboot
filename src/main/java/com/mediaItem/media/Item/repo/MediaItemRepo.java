package com.mediaItem.media.Item.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mediaItem.media.Item.entity.MediaItem;

@RepositoryRestResource(exported =  false)
public interface MediaItemRepo extends CrudRepository<MediaItem, String> {
	Optional<MediaItem> findById(String Id);

	Optional<MediaItem> findByName(String name);

	Iterable<MediaItem> findByMedium(String medium);
}

/*
insert into usr_media_item.media_category values ('C01','Action');
insert into usr_media_item.media_category values ('C02','Science Fiction');
insert into usr_media_item.media_category values ('C03','Comedy');
insert into usr_media_item.media_category values ('C04','Drama');
insert into usr_media_item.media_category values ('C05','Horror');
insert into usr_media_item.media_category values ('C06','Romance');


insert into usr_media_item.media_medium values ('M01','Movies');
insert into usr_media_item.media_medium values ('M02','Series');
 {
          "name": "Firebug",
          "medium": "Series",
          "category": "Science Fiction",
          "year": 2010,
          "watchedOn": "1294166565384",
          "isFavorite": false
        }
         {
          "name": "The Small Tall",
          "medium": "Movies",
          "category": "Comedy",
          "year": 2015,
          "watchedOn": null,
          "isFavorite": true
        }
         {
          "name": "The Redemption",
          "medium": "Movies",
          "category": "Action",
          "year": 2016,
          "watchedOn": null,
          "isFavorite": true
        }
         {
          "name": "Happy Joe: Cheery Road",
          "medium": "Movies",
          "category": "Action",
          "year": 2015,
          "watchedOn": "1457166565384",
          "isFavorite": false
        }
         {
          "name": "Hoopers",
          "medium": "Series",
          "category": "Drama",
          "year": null,
          "watchedOn": null,
          "isFavorite": true
        }
*/