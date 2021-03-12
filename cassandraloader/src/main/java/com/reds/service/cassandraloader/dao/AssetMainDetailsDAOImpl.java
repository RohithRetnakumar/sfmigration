package com.reds.service.cassandraloader.dao;

import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.reds.library.redsutils.json.Json;
import com.reds.service.cassandraloader.dos.AssetMainDetails;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

public class AssetMainDetailsDAOImpl implements AssetMainDetailsDAO {

	private Cluster cluster = null;
	private PreparedStatement insertStatement = null;
	private Session session = null;

	private final String INSERT = "INSERT INTO sf_inventory.asset_main_details (iccid,mdn_no,product_id,product_category_id,activation_date,asset_data_json,asset_status,box_id,channel_id,cluster_id,created_on,created_user,description,distribution_warehouse_id,distributor_id,expiry_date,fg_number,id,modified_on,modified_user,owner_id,owner_type,price,product_category_name,product_name,production_warehouse_id,region_id,reserved_so_id,status,termination_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public AssetMainDetailsDAOImpl() {
		this.cluster = Cluster.builder()
				.addContactPoint(CassandraloaderTreasury.open.takeCassandraloaderConfig().getNodeAddress()).build();
		this.session = cluster.connect(CassandraloaderTreasury.open.takeCassandraloaderConfig().getKeyspaceName());

		this.insertStatement = session.prepare(INSERT);
	}

	@Override
	public void insert(List<AssetMainDetails> dos) throws Exception {

		for (AssetMainDetails assetMainDetails : dos) {

			BoundStatement bound = this.insertStatement.bind().setString(0, assetMainDetails.getKey().getIccId())
					.setString(1, assetMainDetails.getKey().getMdnNo())
					.setLong(2, assetMainDetails.getKey().getProductId())
					.setLong(3, assetMainDetails.getKey().getProductCategoryId())
					.setTimestamp(4, assetMainDetails.getActivationDate())
					.setString(5, assetMainDetails.getAssetDataJson()).setString(6, assetMainDetails.getAssetStatus())
					.setString(7, assetMainDetails.getBoxId()).setString(8, assetMainDetails.getChannelId())
					.setString(9, assetMainDetails.getCluster()).setTimestamp(10, assetMainDetails.getCreatedOn())
					.setString(11, assetMainDetails.getCreatedUser()).setString(12, assetMainDetails.getDescription())
					.setLong(13, assetMainDetails.getDistributionWarehouseId())
					.setString(14, assetMainDetails.getDistributorId())
					.setTimestamp(15, assetMainDetails.getExpiryDate())
					// .setString(16, assetMainDetails.getFgNumber())
					.setString(17, assetMainDetails.getId()).setTimestamp(18, assetMainDetails.getModifiedOn())
					.setString(19, assetMainDetails.getModifiedUser()).setString(20, assetMainDetails.getOwnerId())
					.setString(21, assetMainDetails.getOwnerType()).setDouble(22, assetMainDetails.getPrice())
					.setString(23, assetMainDetails.getProductCategoryName())
					.setString(24, assetMainDetails.getProductName())
					.setLong(25, assetMainDetails.getProductionWarehouseId())
					.setString(26, assetMainDetails.getRegion())
					// .setLong(27, assetMainDetails.getReservedSoId())
					.setString(28, assetMainDetails.getStatus())
					.setTimestamp(29, assetMainDetails.getTerminationDate());

			this.session.execute(bound);
		}
		CassandraloaderTrack.me.info("Inserted {} records into asset_main_details ", dos.size());

	}

	private AssetDetails getAssetDetails(AssetMainDetails assetMainDetails) {
		AssetDetails assetDetails = new AssetDetails();
		assetDetails.setIccId(assetMainDetails.getKey().getIccId());
		assetDetails.setMdnNo(assetMainDetails.getKey().getMdnNo());
		Product product = new Product();// TODO check impact of latest table change

		// ProductCategory productCategory = new ProductCategory();
		// productCategory.setId(assetMainDetails.getKey().getProductCategoryId());
		product.setProductName(assetMainDetails.getProductName());
		// productCategory.setProductCategory(assetMainDetails.getProductCategoryName());
		product.setId(assetMainDetails.getKey().getProductId());

		// assetDetails.setId(assetMainDetails.getId());
		assetDetails.setPrice(assetMainDetails.getPrice());
		assetDetails.setChannelId(assetMainDetails.getChannelId());
		assetDetails.setRegionId(assetMainDetails.getRegion());
		assetDetails.setClusterId(assetMainDetails.getCluster());
		assetDetails.setOwnerId(assetMainDetails.getOwnerId());
		assetDetails.setOwnerType(assetMainDetails.getOwnerType());
		assetDetails.setProductionWarehouseId(assetMainDetails.getProductionWarehouseId());
		assetDetails.setDistributionWarehouseId(assetMainDetails.getDistributionWarehouseId());
		assetDetails.setDistributorId(assetMainDetails.getDistributorId());
		assetDetails.setBoxId(assetMainDetails.getBoxId());
		assetDetails.setExpiryDate(assetMainDetails.getExpiryDate());
//		assetDetails.setReservedSoId(assetMainDetails.getReservedSoId());
//		assetDetails.setFgNumber(assetMainDetails.getFgNumber());
		assetDetails.setActivationDate(assetMainDetails.getActivationDate());
		assetDetails.setTerminationDate(assetMainDetails.getTerminationDate());
		assetDetails.setDescription(assetMainDetails.getDescription());
		assetDetails.setCreatedUser(assetMainDetails.getCreatedUser());
		assetDetails.setCreatedOn(assetMainDetails.getCreatedOn());
		assetDetails.setModifiedUser(assetMainDetails.getModifiedUser());
		assetDetails.setModifiedOn(assetMainDetails.getModifiedOn());
		assetDetails.setStatus(assetMainDetails.getStatus());

		// product.setProductCategory(productCategory);
		assetDetails.setProduct(product);

		return assetDetails;
	}

//	private LocalDate convertDate(Date activationDate) {
//		if (activationDate == null) {
//			return LocalDate.fromMillisSinceEpoch(new Date().getTime());
//		} else {
//			return LocalDate.fromMillisSinceEpoch(activationDate.getTime());
//		}
//
//	}

}
