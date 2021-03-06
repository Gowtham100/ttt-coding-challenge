package com.example.ttt_codingchallenge;

import java.util.Properties;

import com.example.ttt_codingchallenge.model.jpa.ApplicantInfo;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * DBConnection interface is implemented in order to set the configurations for the SessionFactory
  */
@Service
@Profile("prod")
public class ProdHibernateUtil implements DbConnection {

    private SessionFactory sessionFactory;

    /**
     * This method sets and gets the right session factory to connect to the database
     * @return sessionFactory with the right configurations to connect to the PostgreSQL DB
     */
    @Override
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/CTCJobPosting");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "Password123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL82Dialect");
                settings.put(Environment.SHOW_SQL, "true");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(JobApplications.class);
                configuration.addAnnotatedClass(ApplicantInfo.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
