package com.example.ttt_codingchallenge.DAO;

import com.example.ttt_codingchallenge.DbConnection;
import com.example.ttt_codingchallenge.model.jpa.ApplicantInfo;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class JobApplicantsDAO {

    @Autowired
    private DbConnection dbConnection;

    public List<JobApplications> getJobApplicant() {
        try (Session session = dbConnection.getSessionFactory().openSession()) {
            Query query = session.createNativeQuery(
                    "SELECT * FROM \"ApplicantInfo\"", ApplicantInfo.class);

            return query.getResultList();
        }
    }
}
