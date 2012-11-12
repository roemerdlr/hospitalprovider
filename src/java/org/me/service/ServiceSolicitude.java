/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.service;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.me.hospital.Solicitude;

/**
 *
 * @author ROEMER
 */
@WebService(serviceName = "ServiceSolicitude")
public class ServiceSolicitude {

    /**
     * Web service operation
     */
    private Solicitude solicitude = new Solicitude();

    @WebMethod(operationName = "registerSolicitude")
    public boolean registerSolicitude(@WebParam(name = "medicalinput") int medicalinput, @WebParam(name = "amount") int amount) {
        solicitude.setMedicalInput(medicalinput);
        solicitude.setAmount(amount);
        return solicitude.register();
    }

    @WebMethod(operationName = "getAllSolicitudesNotCancel")
    public List<String> getAllSolicitudesNotCancel() {
        return solicitude.getAllSolicitudesNotCancel();
    }

    @WebMethod(operationName = "getSolicitude")
    public List<String> getSolicitude(@WebParam(name = "id") int id) {
        return solicitude.getSolicitude(id);
    }
}
