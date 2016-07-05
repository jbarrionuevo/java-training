package edu.globant.persistence.DAO.hibernate.utils;

import org.hibernate.SessionFactory;

import edu.globant.utils.MySQLDataSourceProvider;

public interface HibernateFactory {

	static final String configurationPath = "/edu/globant/config/database.properties";
	static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";

	public default SessionFactory getHibernateSessionFactory() {
		MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();

		return HibernateUtils.buildSessionFactory(hibernateConfigXml, dsProvider.getMySQLDataSource(configurationPath));
	}
}
