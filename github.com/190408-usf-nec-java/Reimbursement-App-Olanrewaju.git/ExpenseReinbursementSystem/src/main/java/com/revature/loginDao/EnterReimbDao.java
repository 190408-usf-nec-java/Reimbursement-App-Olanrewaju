package com.revature.loginDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.connectionUtil.ConnectionUtil;
import com.revature.credentials.CredentialsTicket;
import com.revature.credentials.ReimbursementData;

public class EnterReimbDao {
	ObjectMapper om = new ObjectMapper();
	Date date= new Date(0);
	
	public void EnterReimb(CredentialsTicket credentialTickets, ReimbursementData data) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ers_reimbursement "
					+ "(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)"
					+ " VALUES (?, ?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Assigning parameters
						ps.setInt(1, credentialTickets.getReimb_amount());
						
						long time = date.getTime();
						Timestamp ts = new Timestamp(time);
			
						ps.setTimestamp(2, ts);
						ps.setString(3, credentialTickets.getReimb_description());
						ps.setInt(4, credentialTickets.getReimb_author_id());
						ps.setInt(5, 1);
						ps.setInt(6, credentialTickets.getReimb_type_id());
			
						ps.executeUpdate();
		}
			 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

}
