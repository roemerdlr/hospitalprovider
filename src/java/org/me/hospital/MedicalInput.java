/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ROEMER
 */
public class MedicalInput {

    public MedicalInput() {
        try {
            this.db = new DB();
            s = db.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean register() {
        try {
            return s.execute("INSERT INTO `medicalinput`(`supplier`, `name`, `description`, `price`) VALUES (" + this.supplier + ",'" + this.name + "','" + this.description + "'," + this.price + ")");
        } catch (SQLException ex) {
            Logger.getLogger(MedicalInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<String> getAllIdMedicalInput() {
        List<String> ls = new ArrayList<String>();
        try {

            ResultSet executeQuery = this.s.executeQuery("SELECT * FROM `medicalinput`");
            while (executeQuery.next()) {
                ls.add(executeQuery.getObject(1).toString());
            }
            return ls;
        } catch (SQLException ex) {
            Logger.getLogger(Solicitude.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    private Statement s;
    private DB db;
    private String name;
    private String description;
    private String supplier;
    private String price;

    public List<String> getMedicalInput(int id) {
      List<String> ls = new ArrayList<String>();
        try {

            ResultSet executeQuery = this.s.executeQuery("SELECT * FROM `medicalinput` WHERE `id`=" + id);
            while (executeQuery.next()) {
                ls.add(executeQuery.getObject(1).toString());
                ls.add(executeQuery.getObject(2).toString());
                ls.add(executeQuery.getObject(3).toString());
            }
            return ls;
        } catch (SQLException ex) {
            Logger.getLogger(Solicitude.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}
