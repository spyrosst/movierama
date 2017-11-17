package com.spyrosst.demo.movierama.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movr_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String hashedPassword;

	@OneToMany(mappedBy = "publishedByUser", fetch = FetchType.LAZY)
	private Set<Movie> publishedMovies = new HashSet<Movie>();

	@OneToMany(mappedBy = "postedByUser", fetch = FetchType.LAZY)
	private Set<Opinion> postedOpinions = new HashSet<Opinion>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public Set<Movie> getPublishedMovies() {
		return publishedMovies;
	}

	public void setPublishedMovies(Set<Movie> publishedMovies) {
		this.publishedMovies = publishedMovies;
	}

	public Set<Opinion> getPostedOpinions() {
		return postedOpinions;
	}

	public void setPostedOpinions(Set<Opinion> postedOpinions) {
		this.postedOpinions = postedOpinions;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String firstName, String lastName, String hashedPassword) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hashedPassword = hashedPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", hashedPassword=" + hashedPassword + ", publishedMovies=" + publishedMovies + ", postedOpinions="
				+ postedOpinions + "]";
	}
	
	

}
