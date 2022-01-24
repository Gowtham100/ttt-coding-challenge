package com.example.ttt_codingchallenge.DAO;

import com.example.ttt_codingchallenge.DbConnection;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * This class is the Data Access Object for Job applications.
 * The SQL will output a list of all the applications that are submitted
  */
@Repository
public class JobApplicationsDAO {
    @Autowired
    private DbConnection dbConnection;

    private final String JOBAPPINFOSQL = "SELECT  \"Applications\".id, \"Jobs\".job_id, \"Volunteers\".applicant_first_name, \"Volunteers\".applicant_last_name, \"Jobs\".job_title, \"Jobs\".job_desc " +
            " FROM \"Applications\" " +
            "INNER JOIN \"Jobs\" ON \"Applications\".job_id = \"Jobs\".job_id " +
            "INNER JOIN \"Volunteers\" ON \"Applications\".volunteer_id = \"Volunteers\".volunteer_id" +
            " WHERE \"Applications\".id = \"Applications\".id ;";

    /**
     * Query is ran using the PostgreSQL database
     * @return List of all applications applied by a volunteer
     */
    public List<JobApplications> getJobApplications() {
        try (Session session = dbConnection.getSessionFactory().openSession()) {
            Query query = session.createNativeQuery(JOBAPPINFOSQL, JobApplications.class);
            return query.getResultList();
        }
    }
}
