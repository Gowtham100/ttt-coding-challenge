package com.example.ttt_codingchallenge;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationDAOTest {

    @Autowired
    private DbConnection dbConnection;

    /**
     * Testing a false connection to make sure dbConnection is working as expected
     */
    @Test
    public void testFalseConnection() {
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    Session session = dbConnection.getSessionFactory().openSession();
                });
    }


}
