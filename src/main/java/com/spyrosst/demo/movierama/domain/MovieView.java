package com.spyrosst.demo.movierama.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movr_vw_movies")
public class MovieView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String description;	

	private Date publishedDate;

	private Long publishedByUserId;

	private String firstName;

	private String lastName;

	private Integer likes;

	private Integer dislikes;

	private Integer daysPublished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}	

	public Long getPublishedByUserId() {
		return publishedByUserId;
	}

	public void setPublishedByUserId(Long publishedByUserId) {
		this.publishedByUserId = publishedByUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getDaysPublished() {
		return daysPublished;
	}

	public void setDaysPublished(Integer daysPublished) {
		this.daysPublished = daysPublished;
	}

	@Override
	public String toString() {
		return "MovieView [id=" + id + ", title=" + title + ", description=" + description + ", publishedDate="
				+ publishedDate + ", publishedByUserId=" + publishedByUserId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", likes=" + likes + ", dislikes=" + dislikes + ", daysPublished="
				+ daysPublished + "]";
	}

}
