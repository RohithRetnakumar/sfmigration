package com.reds.service.cassandraloader.dao;

import java.util.Date;

//Entity
//Table(name = "MATERIAL_TYPE")
public class MaterialType {

	// Id
	// GeneratedValue(strategy = GenerationType.IDENTITY)
	// Column(name = "id")
	private Long id;

	// Column(name = "material_type")
	private String materialType;

	// Column(name = "description")
	private String description;

	// Column(name = "material_grouping")
	private String materialGrouping;

	// CreationTimestamp
	// Column(name = "created_on")
	private Date createdOn;

	// UpdateTimestamp
	// Column(name = "modified_on")
	private Date modifiedOn;

	// Version
	private int version;

	public String getMaterialGrouping() {
		return materialGrouping;
	}

	public void setMaterialGrouping(String materialGrouping) {
		this.materialGrouping = materialGrouping;
	}

	public int getVersion() {
		return version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
