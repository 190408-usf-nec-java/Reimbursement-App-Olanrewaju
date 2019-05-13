package com.revature.loginDao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.connectionUtil.ConnectionUtil;
import com.revature.credentials.Credentials;
import com.revature.credentials.ReimbursementData;

public class ManagerDao {
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
	LinkedList<String>  reimb_lastnamelink = new LinkedList();
	LinkedList<String> reimb_firstnamelink= new LinkedList();
	LinkedList<Integer> reimb_authorLink = new LinkedList();
	
	public ReimbursementData login(Credentials credentials) {
		int i = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? and ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Assigning parameters
						ps.setString(1, credentials.getUsername());
						ps.setString(2, credentials.getPassword());
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				
			R.setErs_user_id(rs.getInt("ERS_USERS_ID"));
		
			
			}
			
				
			try  {
				String sql1 = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_RESOLVER=?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);

				ps1.setInt(1, R.getErs_user_id());
	
				
			
				ResultSet rs1= ps1.executeQuery();
				while(rs1.next()) {
				reim_status_id.add(rs1.getInt("REIMB_STATUS_ID"));
				R.setReim_status_id(reim_status_id);
				reim_type_id.add(rs1.getInt("REIMB_TYPE_ID"));
				R.setReim_type_id(reim_type_id);
				reimb_authorLink.add(rs1.getInt("REIMB_AUTHOR"));
				R.setReim_authorLink(reimb_authorLink);
				i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			
			
			for(int k = 0; k<reimb_authorLink.size(); k++) {
				try  {
					String sql5 = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?";
					PreparedStatement ps5 = conn.prepareStatement(sql5);
					
					ps5.setInt(1, reimb_authorLink.get(k));
		
					
				
					ResultSet rs5= ps5.executeQuery();
					while(rs5.next()) {
						reimb_firstnamelink.add(rs5.getString("USER_FIRST_NAME"));
						R.setReimb_firstnameLink(reimb_firstnamelink);
						reimb_lastnamelink.add(rs5.getString("USER_LAST_NAME"));
						R.setReimb_lastnameLink(reimb_lastnamelink);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
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
				String sql4 = "SELECT * FROM ERS_USERS JOIN ERS_REIMBURSEMENT ON ERS_USERS.ERS_USERS_ID =? and ERS_REIMBURSEMENT.REIMB_RESOLVER =?";
				PreparedStatement ps4 = conn.prepareStatement(sql4);

				ps4.setInt(1, R.getErs_user_id());
				ps4.setInt(2, R.getErs_user_id());
				
			
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
