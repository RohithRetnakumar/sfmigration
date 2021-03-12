package com.reds.service.cassandraloader.dao;

import java.util.Date;

//@Entity
//@Table(name = "ASSET_STATES")
public class AssetStates {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	private Long id;

	// @Enumerated(EnumType.STRING)
	private AssetStateEnum assetState;

	// @Column(name="description")
	private String description;

	// @Column(name="created_user")
	private String createdUser;

	// @Column(name="created_on")
	private Date createdOn;

	// @Column(name="modified_user")
	private String modifiedUser;

	// @Column(name="modified_on")
	private Date modifiedOn;

	public AssetStates(Long id) {
		super();
		this.id = id;
	}

	public AssetStates() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssetStateEnum getAssetState() {
		return assetState;
	}

	public void setAssetState(AssetStateEnum assetState) {
		this.assetState = assetState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
