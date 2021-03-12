package com.reds.service.cassandraloader.dao;

import java.util.Date;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;

public class AssetTransactionStatusHistoryDAOImpl implements AssetTransactionStatusHistoryDAO {

	private Cluster cluster = null;
	private PreparedStatement insertStatement = null;
	private Session session = null;

	private final String INSERT = "INSERT INTO sf_inventory.asset_transaction_status_history (asset_detail_id,order_id,transaction_id,transaction_date,process_type,access_via,asset_status,cancelled,checkin_id,created_on,created_user,cross_channel,cross_cluster,cross_region,description,from_channel_id,from_cluster,from_owner_id,from_owner_type,from_region,master_transaction_id,payment_mode,price,product_category,product_category_name,product_name,program_id,program_name,to_channle_id,to_cluster,to_owner_id,to_owner_type,to_region,transactionamount) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public AssetTransactionStatusHistoryDAOImpl() {
		this.cluster = Cluster.builder()
				.addContactPoint(CassandraloaderTreasury.open.takeCassandraloaderConfig().getNodeAddress()).build();
		this.session = cluster.connect(CassandraloaderTreasury.open.takeCassandraloaderConfig().getKeyspaceName());

		this.insertStatement = session.prepare(INSERT);
	}

	@Override
	public void insert(List<AssetCassandraTransactionHistory> dos) throws Exception {

		for (AssetCassandraTransactionHistory transactionHistory : dos) {
			BoundStatement bound = this.insertStatement.bind()
					.setString(0, transactionHistory.getKey().getAssetDetailId())
					.setString(1, transactionHistory.getKey().getOrderId())
					.setString(2, transactionHistory.getKey().getTransactionId())
					.setDate(3, convertDate(transactionHistory.getKey().getTransactionDate()))
					.setString(4, transactionHistory.getKey().getProcessType())
					.setString(5, transactionHistory.getAccessVia()).setString(6, transactionHistory.getAssetStatus())
					.setBool(7, transactionHistory.getCancelled()).setString(8, transactionHistory.getCheckinId())
					.setDate(9, convertDate(transactionHistory.getCreatedOn()))
					.setString(10, transactionHistory.getCreatedUser())
					.setBool(11, transactionHistory.getCrossChannel()).setBool(12, transactionHistory.getCrossCluster())
					.setBool(13, transactionHistory.getCrossRegion()).setString(14, transactionHistory.getDescription())
					.setString(15, transactionHistory.getFromChannelId())
					.setString(16, transactionHistory.getFromCluster())
					.setString(17, transactionHistory.getFromOwnerId())
					.setString(18, transactionHistory.getFromOwnerType())
					.setString(21, transactionHistory.getPaymentMode()).setDouble(22, transactionHistory.getPrice())
					.setString(23, transactionHistory.getProductCategory())
					.setString(24, transactionHistory.getProductCategoryName())
					.setString(25, transactionHistory.getProductName()).setString(26, transactionHistory.getProgramId())
					.setString(27, transactionHistory.getProgramName())
					.setString(28, transactionHistory.getToChannelId()).setString(29, transactionHistory.getToCluster())
					.setString(30, transactionHistory.getToOwnerId()).setString(31, transactionHistory.getToOwnerType())
					.setString(32, transactionHistory.getToRegion())
					.setDouble(33, transactionHistory.getTransactionAmount());

			this.session.execute(bound);
		}

	}

	private LocalDate convertDate(Date activationDate) {
		return LocalDate.fromMillisSinceEpoch(activationDate.getTime());

	}

}
