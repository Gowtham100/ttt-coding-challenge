package com.example.ttt_codingchallenge.DAO;

import com.example.ttt_codingchallenge.DbConnection;
import com.example.ttt_codingchallenge.model.jpa.ApplicantInfo;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * This class is the Data Access Object for Job applicants.
 * The SQL will output a list of volunteers that applied for a particular job
  */
@Repository
public class JobApplicantsDAO {

    @Autowired
    private DbConnection dbConnection;


    private final String VOLUNTEERINFOSQL = "SELECT \"Jobs\".job_id,\"Jobs\".job_title, " +
            "string_agg(CONCAT(\"Volunteers\".applicant_first_name, ' ', \"Volunteers\".applicant_last_name), ', ') AS volunteer_info " +
            "FROM \"Applications\" " +
            "INNER JOIN \"Jobs\" ON \"Applications\".job_id = \"Jobs\".job_id " +
            "INNER JOIN \"Volunteers\" ON \"Applications\".volunteer_id = \"Volunteers\".volunteer_id " +
            "WHERE \"Jobs\".job_id = \"Applications\".job_id " +
            "GROUP BY \"Jobs\".job_id, \"Jobs\".job_title" +
            " ORDER BY \"Jobs\".job_id";

    /**
     * Query is ran using the PostgreSQL database
     * @return List of JobApplications that is then mapped
     */
    public List<ApplicantInfo> getJobApplicant() {
        try (Session session = dbConnection.getSessionFactory().openSession()) {
            Query query = session.createNativeQuery(VOLUNTEERINFOSQL, ApplicantInfo.class);

            return query.getResultList();
        }
    }
}
