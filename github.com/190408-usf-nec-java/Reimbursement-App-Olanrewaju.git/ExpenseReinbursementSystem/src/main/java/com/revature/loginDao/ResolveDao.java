package com.revature.loginDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.connectionUtil.ConnectionUtil;
import com.revature.credentials.CredentialsResolve;
import com.revature.credentials.CredentialsTicket;
import com.revature.credentials.ReimbursementData;

public class ResolveDao {
	ObjectMapper om = new ObjectMapper();
	Date date= new Date(0);
	
	public void resolve(CredentialsResolve credentialResolve) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ers_reimbursement SET reimb_status_id=?, reimb_resolved=? WHERE reimb_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Assigning parameters
						ps.setInt(1, credentialResolve.getReimb_status_id());
						ps.setInt(3, credentialResolve.getReimb_id());
						
						long time = date.getTime();
						Timestamp ts = new Timestamp(time);
			
						ps.setTimestamp(2, ts);
			
						ps.executeUpdate();
		}
			 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}
}
