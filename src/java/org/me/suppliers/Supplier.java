package org.me.suppliers;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROEMER
 */
public class Supplier {

    public Supplier() {
        try {
            this.db = new DB();
            s = db.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean register() {
        try {
            boolean rs = s.execute("INSERT INTO `supplier`(`name`) VALUES ('" + this.name + "')");
            s.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private int id;
    private Statement s;
    private DB db;
    private String name;
}
