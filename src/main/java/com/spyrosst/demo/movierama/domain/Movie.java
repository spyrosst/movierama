package com.spyrosst.demo.movierama.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movr_movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false,  unique = true)
	private String title;

	@Lob
	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Date publishedDate = new Date();

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User publishedByUser;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
	private Set<Opinion> opinions = new HashSet<Opinion>();


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

	public User getPublishedByUser() {
		return publishedByUser;
	}

	public void setPublishedByUser(User publishedByUser) {
		this.publishedByUser = publishedByUser;
	}

	public Set<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String description, User publishedByUser) {
		super();
		this.title = title;
		this.description = description;
		this.publishedByUser = publishedByUser;
	}
	
	

}
