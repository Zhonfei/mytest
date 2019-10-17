/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author delta
 */
public class DataBase {
    
    private Connection connection;
    
    private Statement statement;

    public DataBase() {
    }

    public DataBase(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    
}
