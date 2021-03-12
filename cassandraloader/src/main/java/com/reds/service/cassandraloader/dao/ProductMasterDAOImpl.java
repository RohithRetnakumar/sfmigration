package com.reds.service.cassandraloader.dao;

import java.util.Date;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.reds.service.cassandraloader.dos.ProductMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;

public class ProductMasterDAOImpl implements ProductMasterDAO {

	private Cluster cluster = null;
	private PreparedStatement insertStatement = null;
	private Session session = null;

	private final String INSERT = "INSERT INTO sf_inventory.product_master (fg_code,created_on,created_user,description,modified_on,modified_user,product_category,product_category_name,product_hierarchy,product_hierarchy_code,product_name,product_type) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

	
	public ProductMasterDAOImpl() {
		this.cluster = Cluster.builder()
				.addContactPoint(CassandraloaderTreasury.open.takeCassandraloaderConfig().getNodeAddress()).build();
		this.session = cluster.connect(CassandraloaderTreasury.open.takeCassandraloaderConfig().getKeyspaceName());

		this.insertStatement = session.prepare(INSERT);
	}

	@Override
	public void insert(List<ProductMaster> dos) throws Exception {


		for (ProductMaster productmaster : dos) {

			BoundStatement bound = this.insertStatement.bind().setString(0, productmaster.getKey().getFgCode())
					.setDate(1, convertDate(productmaster.getCreatedOn()))
					.setString(2, productmaster.getCreatedUser())
					.setString(3, productmaster.getDescription())
					.setDate(4, convertDate(productmaster.getModifiedOn()))
					.setString(5, productmaster.getModifiedUser())
					.setString(6, productmaster.getProductCategory())
					.setString(7, productmaster.getProductCategoryName())
					.setString(8, productmaster.getProductHierarchy())
					.setString(9, productmaster.getProductHierarchyCode())
					.setString(10, productmaster.getProductName())
					.setString(11, productmaster.getProductType());

			this.session.execute(bound);
		}

	}

	private LocalDate convertDate(Date activationDate) {
		return LocalDate.fromMillisSinceEpoch(activationDate.getTime());

	}

}
