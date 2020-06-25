/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Enzo
 */
public class DBProperties {
    static Properties props = new Properties();
    FileInputStream in = null;

    public DBProperties() {
        try {

            in = new FileInputStream("src/databasedb.properties");
            props.load(in);

        } catch (IOException ex) {

            System.out.println(DBProperties.class.getName() + ex.getMessage());
        }
    }
    
    public static String getDbUrl () {
        return props.getProperty("url");
    }

    public static String getDbUser () {
        return props.getProperty("user");
    }

    public static String getDbPasswd () {
        return props.getProperty("passwd");
    }
}
