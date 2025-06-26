/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author owen
 */
public class DatabasePipeline {
    
    private static final String url = "jdbc:sqlite:" + new File("Assets/database.db").getPath();
    
    public static java.sql.Connection openConnection() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection(url);
    }
    
}
