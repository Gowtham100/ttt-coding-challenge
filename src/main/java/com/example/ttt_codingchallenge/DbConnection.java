package com.example.ttt_codingchallenge;
import org.hibernate.SessionFactory;

/**
 * Interface for the Session factory
  */
public interface DbConnection {
    SessionFactory getSessionFactory();
}