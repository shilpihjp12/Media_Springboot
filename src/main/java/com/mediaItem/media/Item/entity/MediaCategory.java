package com.mediaItem.media.Item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;



@Table(name="media_category")
@Entity
public class MediaCategory  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	@Id
	private String Id;
	
	@Column(name="category")
	private String category;
	
	public MediaCategory(String id, String category) {
		this.Id = id;
		this.category = category;
	}

	private MediaCategory() {}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

}
