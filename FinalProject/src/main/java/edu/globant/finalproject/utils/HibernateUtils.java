package edu.globant.finalproject.utils;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.finalproject.hibernate.Case;
import edu.globant.finalproject.hibernate.Design;
import edu.globant.finalproject.hibernate.Device;
import edu.globant.finalproject.hibernate.Provider;


public final class HibernateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

	public static SessionFactory buildSessionFactory(String hibernateConfigXml, DataSource dataSource) {
		try {
			Configuration configuration = new Configuration();

			configuration.configure(hibernateConfigXml)
				.addAnnotatedClass(Case.class)
				.addAnnotatedClass(Design.class)
				.addAnnotatedClass(Device.class)
				.addAnnotatedClass(Provider.class);
			SessionFactory sf = configuration
				.buildSessionFactory(
					new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.applySetting(Environment.DATASOURCE, dataSource)
						.build());
			return sf;
		} catch (Exception ex) {
			LOGGER.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
