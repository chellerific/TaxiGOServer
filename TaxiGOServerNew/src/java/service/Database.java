/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import hibernatedata.Admininfo;
import hibernatedata.Bookings;
import hibernatedata.MyHelper;
import hibernatedata.Taxioperator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sara
 */
@WebService(serviceName = "Database")
public class Database {

    /**
     * This is a sample web service operation
     */
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "getadmininfo")
    public List <Admininfo> getAdmininfo() {
        MyHelper helper = new MyHelper();
        List <Admininfo> send = helper.getAdmins();
        
        return send;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getbookings")
    public List <Bookings> getBookings() {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        List <Bookings> bookings = helper.getBooking();
        
        return bookings;
    }
    
     @WebMethod(operationName = "getpriceinfo")
    public List <Taxioperator> getPriceinfo() {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        List <Taxioperator> taxis = helper.getPriceinfo();
        
        return taxis;
    }
}
