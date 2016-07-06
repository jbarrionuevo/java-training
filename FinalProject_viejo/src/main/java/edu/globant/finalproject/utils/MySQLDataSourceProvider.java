package edu.globant.finalproject.utils;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class MySQLDataSourceProvider {

	public DataSource getMySQLDataSource(String configurationPath) {
		HikariConfig hikariConfig = new HikariConfig(configurationPath);
		return new HikariDataSource(hikariConfig);
	}
}
