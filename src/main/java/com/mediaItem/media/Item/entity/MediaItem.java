package com.mediaItem.media.Item.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Table(name="media_item")
@Entity
public class MediaItem  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name="Id")
	@javax.persistence.Id
	private String Id;
	
	@Column(name="name")
	private String name;
	
	@JoinColumn(name="medium", referencedColumnName = "medium",insertable=false, updatable=false, nullable=true)
	@ManyToOne()
	MediaMedium mediaMedium;
	
	@Column(name="medium", nullable=true)
	private String medium;
	
	@JoinColumn(name="category", referencedColumnName = "category",insertable=false, updatable=false, nullable=true)
	@ManyToOne()
    @NotFound(action = NotFoundAction.IGNORE)
	MediaCategory mediaCategory;
	
	@Column(name="category", nullable=true, insertable=true, updatable=true)
	private String category;
	
	@Column(name="year")
	private int year;
	
	@Column(name="watchedOn")
	private String watchedOn;
	
	
	@Column(name="isFavorite")
	private boolean isFavorite;

	private MediaItem() {
		
	}
	
	public MediaItem(String id, String name, MediaMedium mediaMedium, String medium, MediaCategory mediaCategory,
			String category, int year, String watchedOn, boolean isFavorite) {
		super();
		Id = id;
		this.name = name;
		this.mediaMedium = mediaMedium;
		this.medium = medium;
		this.mediaCategory = mediaCategory;
		this.category = category;
		this.year = year;
		this.watchedOn = watchedOn;
		this.isFavorite = isFavorite;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MediaMedium getMediaMedium() {
		return mediaMedium;
	}

	public void setMediaMedium(MediaMedium mediaMedium) {
		this.mediaMedium = mediaMedium;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public MediaCategory getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(MediaCategory mediaCategory) {
		this.mediaCategory = mediaCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getWatchedOn() {
		return watchedOn;
	}

	public void setWatchedOn(String watchedOn) {
		this.watchedOn = watchedOn;
	}


	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	
}
