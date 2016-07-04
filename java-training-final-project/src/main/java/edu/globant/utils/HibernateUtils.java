package edu.globant.utils;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.domain.Employee;

public final class HibernateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

	public static SessionFactory buildSessionFactory(String hibernateConfigXml, DataSource dataSource) {
		try {
			Configuration configuration = new Configuration();

			configuration.configure(hibernateConfigXml).addAnnotatedClass(Employee.class);
			SessionFactory sf = configuration.buildSessionFactory(
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
							.applySetting(Environment.DATASOURCE, dataSource).build());
			return sf;
		} catch (Exception ex) {
			LOGGER.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
