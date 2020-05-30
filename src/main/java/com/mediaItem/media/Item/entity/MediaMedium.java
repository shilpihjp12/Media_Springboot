package com.mediaItem.media.Item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Table(name="media_medium")
@Entity
public class MediaMedium  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	@Id
	private String Id;
	
	@Column(name="medium")
	private String medium;
	
	public MediaMedium(String id, String medium) {
		this.Id = id;
		this.medium = medium;
	}
	
	private MediaMedium() {}
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}
	
}
