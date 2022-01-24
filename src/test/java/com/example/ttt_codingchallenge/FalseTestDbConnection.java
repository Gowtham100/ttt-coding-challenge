package com.example.ttt_codingchallenge;

import com.example.ttt_codingchallenge.model.jpa.ApplicantInfo;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class FalseTestDbConnection implements  DbConnection{
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/CTCJobPosting");
                settings.put(Environment.USER, "testFalseConnection");
                settings.put(Environment.PASS, "");
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
