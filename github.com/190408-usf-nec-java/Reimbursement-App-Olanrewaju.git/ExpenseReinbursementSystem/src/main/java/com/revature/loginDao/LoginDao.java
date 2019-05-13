package com.revature.loginDao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.revature.credentials.Credentials;
import com.revature.credentials.ReimbursementData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.connectionUtil.ConnectionUtil;

public class LoginDao {
	int id;
	ObjectMapper om = new ObjectMapper();
	ReimbursementData R = new ReimbursementData();
	LinkedList<Integer> reimb_id = new LinkedList();
	LinkedList<Integer> reimb_amount = new LinkedList();
	LinkedList<Integer> reim_resolver = new LinkedList();
	LinkedList<Integer> reim_status_id = new LinkedList();
	LinkedList<Integer> reim_type_id = new LinkedList();
	LinkedList<String>  reimb_description = new LinkedList();
	LinkedList<String> reimb_status= new LinkedList();
	LinkedList<String> reim_type= new LinkedList();
	LinkedList<Timestamp> reimb_resolved = new LinkedList();
	LinkedList<Timestamp> reimb_submitted= new LinkedList();
	LinkedList<Blob> Reimb_receipt= new LinkedList();
	int i = 0;
	
	
	
	public ReimbursementData login(Credentials credentials) {
		//ReimbursementData R = new ReimbursementData();
		
		int i = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? and ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Assigning parameters
						ps.setString(1, credentials.getUsername());
						ps.setString(2, credentials.getPassword());
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			R.setReimb_firstname(rs.getString("USER_FIRST_NAME"));
			R.setReimb_lastname(rs.getString("USER_LAST_NAME"));
			R.setReim_author(rs.getInt("ERS_USERS_ID"));
			
			}
			try  {
				String sql1 = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);

				ps1.setInt(1, R.getReim_author());
	
				
			
				ResultSet rs1= ps1.executeQuery();
				while(rs1.next()) {
				reim_status_id.add(rs1.getInt("REIMB_STATUS_ID"));
				R.setReim_status_id(reim_status_id);
				reim_type_id.add(rs1.getInt("REIMB_TYPE_ID"));
				R.setReim_type_id(reim_type_id);
				i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			for(int k = 0; k<reim_status_id.size(); k++) {
			try  {
				String sql2 = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID=?";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				
				ps2.setInt(1, reim_status_id.get(k));
	
				
			
				ResultSet rs2= ps2.executeQuery();
				while(rs2.next()) {
				reimb_status.add(rs2.getString("REIMB_STATUS"));
				R.setReimb_status(reimb_status);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			}
			for(int k = 0; k<reim_type_id.size(); k++) {
				try  {
					String sql3 = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID=?";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					
					ps3.setInt(1, reim_type_id.get(k));
		
					
				
					ResultSet rs3= ps3.executeQuery();
					while(rs3.next()) {
					reim_type.add(rs3.getString("REIMB_TYPE"));
					R.setReimb_type(reim_type);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
				}
			try  {
				String sql4 = "SELECT * FROM ERS_USERS JOIN ERS_REIMBURSEMENT ON ERS_USERS.ERS_USERS_ID =? and ERS_REIMBURSEMENT.REIMB_AUTHOR =?";
				PreparedStatement ps4 = conn.prepareStatement(sql4);

				ps4.setInt(1, R.getReim_author());
				ps4.setInt(2, R.getReim_author());
				
			
				ResultSet rs4= ps4.executeQuery();
				while(rs4.next()) {
					reimb_description.add(rs4.getString("REIMB_DESCRIPTION"));
					R.setReimb_description(reimb_description);
					reimb_submitted.add(rs4.getTimestamp("REIMB_SUBMITTED"));
					R.setReimb_submitted(reimb_submitted);
					reimb_resolved.add(rs4.getTimestamp("REIMB_RESOLVED"));
					R.setReimb_resolved(reimb_resolved);
					reimb_amount.add(rs4.getInt("REIMB_AMOUNT"));
					R.setReimb_amount(reimb_amount);
					reim_resolver.add(rs4.getInt("REIMB_RESOLVER"));
					R.setReim_resolver(reim_resolver);
					reimb_id.add(rs4.getInt("REIMB_ID"));
					R.setReimb_id(reimb_id);
					Reimb_receipt.add(rs4.getBlob("REIMB_RECEIPT"));
					R.setReimb_receipt(Reimb_receipt);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			
		}
		// TODO Auto-generated method stub
 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return R;
	}
	
}
