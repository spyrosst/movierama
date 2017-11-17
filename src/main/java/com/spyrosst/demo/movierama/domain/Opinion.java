package com.spyrosst.demo.movierama.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "movr_opinions", uniqueConstraints={@UniqueConstraint(columnNames = {"movie_id", "posted_by_user_id"})}) 
public class Opinion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Integer opinion;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Movie movie;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User postedByUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOpinion() {
		return opinion;
	}

	public void setOpinion(Integer opinion) {
		this.opinion = opinion;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getPostedByUser() {
		return postedByUser;
	}

	public void setPostedByUser(User postedByUser) {
		this.postedByUser = postedByUser;
	}

	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Opinion(Integer opinion, Movie movie, User postedByUser) {
		super();
		this.opinion = opinion;
		this.movie = movie;
		this.postedByUser = postedByUser;
	}

	@Override
	public String toString() {
		return "Opinion [id=" + id + ", opinion=" + opinion + ", movie=" + movie.getId() + ", postedByUser=" + postedByUser.getId()
				+ "]";
	}
	
	

}
