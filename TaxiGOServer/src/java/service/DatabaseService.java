/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import taxigo.MyHelper;
import taxigo.Admininfo;

/**
 *
 * @author Sara
 */
@WebService(serviceName = "DatabaseService")
public class DatabaseService {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "getadmininfo")
    public List <Admininfo> getAdmininfo() {
        MyHelper helper = new MyHelper();
        List <Admininfo> send = helper.getAdmins();
        
        return send;
    }
}
