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
public class Solicitude {

    public Statement getS() {
        return s;
    }

    public void setS(Statement s) {
        this.s = s;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicalInput() {
        return medicalInput;
    }

    public void setMedicalInput(int medicalInput) {
        this.medicalInput = medicalInput;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean register() {
        try {
            return s.execute("INSERT INTO `solicitude`(`medicalinput`, `amount`) VALUES (" + this.medicalInput + "," + this.amount + ")");
        } catch (SQLException ex) {
            Logger.getLogger(Solicitude.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<String> getAllSolicitudesNotCancel() {
        List<String> ls = new ArrayList<String>();
        try {

            ResultSet executeQuery = this.s.executeQuery("SELECT `id`, `medicalinput`, `amount`, `cancel` FROM `solicitude`  WHERE `cancel`=0");
            while (executeQuery.next()) {
                ls.add(executeQuery.getObject(1).toString());
            }
            return ls;
        } catch (SQLException ex) {
            Logger.getLogger(Solicitude.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public List<String> getSolicitude(int id) {
        List<String> ls = new ArrayList<String>();
        try {

            ResultSet executeQuery = this.s.executeQuery("SELECT `id`, `medicalinput`, `amount`, `cancel` FROM `solicitude` WHERE `id`=" + id);
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

    public Solicitude() {
        try {
            this.db = new DB();
            s = db.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Statement s;
    private DB db;
    private int id;
    private int medicalInput;
    private int amount;
}
