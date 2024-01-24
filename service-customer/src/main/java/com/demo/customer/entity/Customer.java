package com.demo.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El numero de documento no puede ser vacio")
	@Size(min = 8, max = 8, message = "El tamaño del numero de documento es 8")
	@Column(name = "number_id", unique = true, length = 8, nullable = false)
	private String numberID;

	@NotEmpty(message = "El nombre no puede ser vacio")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty(message = "El apellido no puede ser vacio")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotEmpty(message = "El correo no puede ser vacio")
	@Email(message = "No es una direccion de correo bien formada")
	@Column(unique = true, nullable = false)
	private String email;

	@Column(name = "photo_url")
	private String photoUrl;

	@NotNull(message = "La region no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Region region;

	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberID() {
		return numberID;
	}

	public void setNubmerID(String numerID) {
		this.numberID = numerID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
