package taxigo;
// Generated Jan 3, 2017 1:02:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Taxiinfo generated by hbm2java
 */
public class Taxiinfo  implements java.io.Serializable {


     private String username;
     private String password;
     private String email;
     private String phone;
     private Set bookingses = new HashSet(0);
     private Taxioperator taxioperator;

    public Taxiinfo() {
    }

	
    public Taxiinfo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Taxiinfo(String username, String password, String email, String phone, Set bookingses, Taxioperator taxioperator) {
       this.username = username;
       this.password = password;
       this.email = email;
       this.phone = phone;
       this.bookingses = bookingses;
       this.taxioperator = taxioperator;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Set getBookingses() {
        return this.bookingses;
    }
    
    public void setBookingses(Set bookingses) {
        this.bookingses = bookingses;
    }
    public Taxioperator getTaxioperator() {
        return this.taxioperator;
    }
    
    public void setTaxioperator(Taxioperator taxioperator) {
        this.taxioperator = taxioperator;
    }




}

