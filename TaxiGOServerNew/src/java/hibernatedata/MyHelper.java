/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedata;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sara
 */
public class MyHelper {

    Session session = null;

    public MyHelper() {
        this.session = MyHibernateUtil.getSessionFactory().getCurrentSession();

    }

    public List getAdmins() {
        List<Admininfo> adminlist = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Admininfo");
            adminlist = (List<Admininfo>) q.list();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminlist;
    }

    public List getBooking(String username, String usertype) {
        List<Bookings> bookinglist = null;
        try {
            if (usertype.equals("client")) {
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Bookings where customer = '" + username + "'");
                bookinglist = (List<Bookings>) q.list();
                tx.commit();

            } else if (usertype.equals("operator")) {
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Bookings where companyname = '" + username + "'");
                bookinglist = (List<Bookings>) q.list();
                tx.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookinglist;
    }

    public List getPriceinfo() {
        List<Taxioperator> taxilist = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Taxioperator");
            taxilist = (List<Taxioperator>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taxilist;
    }

    public Taxioperator getPriceinfoForOperator(String username) {
        Taxioperator prices = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Taxioperator where operator = '" + username + "'");
            prices = (Taxioperator) q.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prices;
    }

    public String updatePrice(String company, double baserate, double priceperkm, double weekendfee) {

        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "UPDATE Taxioperator set baserate = " + baserate + ", priceperkm = " + priceperkm
                + ", weekendfee = " + weekendfee + "WHERE operator = '" + company + "'";
        Query query = session.createQuery(hql);

        int result = query.executeUpdate();
        System.out.println("RESULT " + result);

        tx.commit();

        return "Your prices have been updated.";
    }

    public String addOperator(String operator, double baserate, double priceperkm, double weekendfee, int rating) {
        org.hibernate.Transaction tx = session.beginTransaction();
        Taxioperator taxi = new Taxioperator(operator, baserate, priceperkm, weekendfee, rating);

        session.save(taxi);
        session.flush();

        tx.commit();

        return "Done";
    }

    public String addOperatorLogin(String operator, String password, String email, String phone) {
        Taxiinfo taxi = new Taxiinfo(operator, password, email, phone);

        org.hibernate.Transaction tx = session.beginTransaction();

        session.save(taxi);
        session.flush();

        tx.commit();

        return "Done";
    }

    public List getClients() {
        List<Clientinfo> clients = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Clientinfo");
            clients = (List<Clientinfo>) q.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }

    public List getOperators() {
        List<Taxiinfo> taxilist = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Taxiinfo");
            taxilist = (List<Taxiinfo>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taxilist;
    }

    public String reportUser(String username) {
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            String hql = "UPDATE Clientinfo set reported = " + true + " WHERE username = '" + username + "'";
            Query query = session.createQuery(hql);

            int result = query.executeUpdate();

            tx.commit();
        } catch (Exception ex) {

        }

        return "Done";
    }
    
    public String removeUser(String username) {
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "Delete Clientinfo where username  = '" + username + "'";
        Query query = session.createQuery(hql);

        int result = query.executeUpdate();

        tx.commit();
        
        return "Done";
    }

}
