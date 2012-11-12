/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.service;

import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.me.suppliers.MedicalInput;
import org.me.suppliers.Supplier;

/**
 *
 * @author ROEMER
 */
@WebService(serviceName = "ServiceSupplier")
public class ServiceSupplier {

    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "name") String name) {
        Supplier s = new Supplier();
        s.setName(name);
        return s.register();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerMedicaInput")
    public boolean registerMedicaInput(@WebParam(name = "supplier") String supplier, @WebParam(name = "name") String name, @WebParam(name = "description") String description, @WebParam(name = "price") String price) throws SQLException {
        MedicalInput m = new MedicalInput();
        m.setSupplier(supplier);
        m.setDescription(description);
        m.setName(name);
        m.setPrice(price);
        return m.register();
    }
}
