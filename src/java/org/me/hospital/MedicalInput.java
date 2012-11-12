/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.hospital;

import java.sql.SQLException;
import java.sql.Statement;
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

    public boolean register(){
        try {
            return s.execute("INSERT INTO `medicalinput`(`supplier`, `name`, `description`, `price`) VALUES (" + this.supplier + ",'" + this.name + "','" + this.description + "'," + this.price + ")");
        } catch (SQLException ex) {
            Logger.getLogger(MedicalInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private Statement s;
    private DB db;
    private String name;
    private String description;
    private String supplier;
    private String price;
}
