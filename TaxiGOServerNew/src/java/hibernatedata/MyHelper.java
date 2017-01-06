/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedata;

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
            adminlist = (List<Admininfo>)q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminlist;
    }

    public List getBooking() {
        List<Bookings> bookinglist = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Bookings");
            bookinglist = (List<Bookings>)q.list();
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
            taxilist = (List<Taxioperator>)q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return taxilist;
    }
    
}
