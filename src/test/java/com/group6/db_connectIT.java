package com.group6;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class db_connectIT {

	db_util db = new db_util();
	Connection con;

	@Test
	public void db_connect() throws SQLException, InterruptedException {
		con = db.getDbConnection();
		assertTrue(con != null);
	}
}
