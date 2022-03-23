package com.example.movies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {
	
	@Autowired
	JdbcTemplate template;

	int getCountAccount(){
		return template.queryForObject("select count(*) from paymentdb",Integer.class);
		
	}

	List<paymentdb> getAll() {
		return template.query("select * from paymentdb ", new paymentMapper());	
	}
	
	void Add(paymentdb payment) {
		template.update("insert into paymentdb values(?,?,?)",new Object[] {payment.id(),payment.name(),payment.balance()});
	}
	
	void Delete(Integer id) {
		template.update("delete from paymentdb where ID = ? ",new Object[] {id});
	}
	void Update( paymentdb paymentdb1,int id) {
	
		template.update("update paymentdb set ID =? ,NAME =?, BALANCE = ? where ID =?", new Object[] {paymentdb1.id(),paymentdb1.name(),paymentdb1.balance(),id});
	}
	
	class paymentMapper implements RowMapper<paymentdb> {   
		// ROWMAPPER CLASS
		@Override
		public paymentdb mapRow(ResultSet rs, int rowNum) throws SQLException {

			paymentdb thepayment = new paymentdb(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("BALANCE"));

			return thepayment;
		}

	}
}
