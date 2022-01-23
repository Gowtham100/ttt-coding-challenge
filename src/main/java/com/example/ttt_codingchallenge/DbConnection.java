package com.example.ttt_codingchallenge;
import org.hibernate.SessionFactory;

public interface DbConnection {
    SessionFactory getSessionFactory();
}