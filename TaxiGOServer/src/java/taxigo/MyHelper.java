/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxigo;

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
            for (int i = 0; i < adminlist.size(); i++) {
                System.out.println(adminlist.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminlist;
    }

}
