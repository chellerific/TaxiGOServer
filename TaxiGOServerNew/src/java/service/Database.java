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
     *
     * @return
     */
    @WebMethod(operationName = "getadmininfo")
    public List<Admininfo> getAdmininfo() {
        MyHelper helper = new MyHelper();
        List<Admininfo> send = helper.getAdmins();

        return send;
    }

    /**
     * Web service operation
     *
     * @param username
     * @param usertype
     * @return
     */
    @WebMethod(operationName = "getbookings")
    public List<Bookings> getBookings(String username, String usertype) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        List<Bookings> bookings = helper.getBooking(username, usertype);

        return bookings;
    }

    @WebMethod(operationName = "getpriceinfo")
    public List<Taxioperator> getPriceinfo() {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        List<Taxioperator> taxis = helper.getPriceinfo();

        return taxis;
    }

    /**
     * Web service operation
     *
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
     * @param operator
     * @param baserate
     * @param priceperkm
     * @param weekendfee
     * @param rating
     * @return 
     */
    @WebMethod(operationName = "addoperator")
    public String addoperator(@WebParam(name = "operator") String operator, @WebParam(name = "baserate") double baserate, @WebParam(name = "priceperkm") double priceperkm, @WebParam(name = "weekendfee") double weekendfee, @WebParam(name = "rating") int rating) {
        MyHelper helper = new MyHelper();
        String add = helper.addOperator(operator, baserate, priceperkm, weekendfee, rating);

        return add;
    }

    /**
     * Web service operation
     * @param operator
     * @param password
     * @param email
     * @param phone
     * @return 
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
     */
    @WebMethod(operationName = "addCustomer")
    public String addCustomer(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "phone") String phone, @WebParam(name = "reported") boolean reported) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        String add = helper.addCustomer(username, password, email, phone, reported);

        return add;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addBooking")
    public String addBooking(@WebParam(name = "companyname") String company,
            @WebParam(name = "customer") String customer, @WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination,
            @WebParam(name = "price") double price, @WebParam(name = "date") String date, @WebParam(name = "time") String time) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        String add = helper.addBooking(company, customer, origin, destination, price, date, time);

        return add;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getOperators")
    public List<Taxiinfo> getOperators() {
        MyHelper helper = new MyHelper();
        List<Taxiinfo> taxis = helper.getOperators();

        return taxis;

    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getclients")
    public List<Clientinfo> getclients() {
        MyHelper helper = new MyHelper();
        List<Clientinfo> clients = helper.getClients();

        return clients;
    }

    /**
     * Web service operation
     * @param operator
     * @return 
     */
    @WebMethod(operationName = "getpriceinfoforoperator")
    public Taxioperator getpriceinfoforoperator(@WebParam(name = "operator") String operator) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        Taxioperator prices = helper.getPriceinfoForOperator(operator);

        return prices;
    }

    /**
     * Web service operation
     * @param username
     * @return 
     */
    @WebMethod(operationName = "reportuser")
    public String reportuser(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        MyHelper helper = new MyHelper();
        String result = helper.reportUser(username);

        return result;
    }

    /**
     * Web service operation
     * @param username
     * @return 
     */
    @WebMethod(operationName = "removeuser")
    public String removeuser(@WebParam(name = "username") String username) {
        MyHelper helper = new MyHelper();
        String result = helper.removeUser(username);

        return result;
    }

}
