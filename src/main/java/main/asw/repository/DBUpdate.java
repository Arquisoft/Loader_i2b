package main.asw.repository;

import java.util.List;

import main.asw.agents.Agent;

public interface DBUpdate {

    /**
     * Inserts each one of the given users into the database
     * @param users
     */
    void insert(List<Agent> users);

    /**
     * Generates the reports for the users
     */
    void writeReport();

}
