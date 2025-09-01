/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author owen
 */
public class DatabasePipeline {
    
    private static final String URL;
    
    static {
        // build a cross-platform absolute path
        String dbPath = Paths.get("Assets", "database.db").toAbsolutePath().toString();
        URL = "jdbc:sqlite:" + dbPath;
    }
    
    public static java.sql.Connection openConnection() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection(URL);
    }
    
}
