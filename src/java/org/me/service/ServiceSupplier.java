/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.me.hospital.MedicalInput;
import org.me.hospital.Supplier;

/**
 *
 * @author ROEMER
 */
@WebService(serviceName = "ServiceSupplier")
public class ServiceSupplier {

    /**
     * This is a sample web service operation
     * @param name 
     * @return 
     */
    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "name") String name) {
        Supplier s = new Supplier();
        s.setName(name);
        return s.register();
    }   
}
