package com.restproducts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private Long id;

	@Column(name = "type_name")
	private String name;

	public Type() {

	}

	public Type(String name) {

	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setTypeName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + name + "]";
	}

}
