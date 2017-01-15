/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import hibernatedata.Admininfo;
import hibernatedata.Bookings;
import hibernatedata.Clientinfo;
import hibernatedata.MyHelper;
import hibernatedata.Taxiinfo;
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
     * @return 
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

    /**
     * Web service operation
     * @param company
     * @param baserate
     * @param priceperkm
     * @param weekendfee
     * @return 
     */
    @WebMethod(operationName = "updatePrice")
    public String updatePrice(@WebParam(name = "company") String company, @WebParam(name = "baserate") double baserate, @WebParam(name = "priceperkm") double priceperkm, @WebParam(name = "weekendfee") double weekendfee) {
        MyHelper helper = new MyHelper();
        String update = helper.updatePrice(company, baserate, priceperkm, weekendfee);
        
        return update;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addoperator")
    public String addoperator(@WebParam(name = "operator") String operator, @WebParam(name = "baserate") double baserate, @WebParam(name = "priceperkm") double priceperkm, @WebParam(name = "weekendfee") double weekendfee, @WebParam(name = "rating") int rating) {
        MyHelper helper = new MyHelper();
        String add = helper.addOperator(operator, baserate, priceperkm, weekendfee, rating);
        
        return add;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addoperatorlogin")
    public String addoperatorlogin(@WebParam(name = "operator") String operator, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "phone") String phone) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        String add = helper.addOperatorLogin(operator, password, email, phone);
        
        return add;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getOperators")
    public List <Taxiinfo> getOperators() {
        MyHelper helper = new MyHelper();
        List <Taxiinfo> taxis = helper.getOperators();
        
        return taxis;
        
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getclients")
    public List <Clientinfo> getclients() {
        MyHelper helper = new MyHelper();
        List <Clientinfo> clients = helper.getClients();
        
        return clients;
    }
    
    
}
