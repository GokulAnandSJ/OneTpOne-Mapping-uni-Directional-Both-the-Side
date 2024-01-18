package com.jsp.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Person p1 = new Person();
        p1.setpId(101);
        p1.setpName("Gokul");
        p1.setpContact(99999);
        
        
        Person p2 = new Person();
        p2.setpId(102);
        p2.setpName("Vivek");
        p2.setpContact(8888);
        
        
        Pan pan1 = new Pan();
        pan1.setPanId(1001);
        pan1.setPanCity("Banglore");
        pan1.setPanNumber(123456);
        pan1.setP(p1);
        
        Pan pan2 = new Pan();
        pan2.setPanId(1002);
        pan2.setPanCity("TamilNadu");
        pan2.setPanNumber(789101);
        pan2.setP(p2);
        
        
        p1.setPan(pan1);
        p2.setPan(pan2);
        
        
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Pan.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session ses = sf.openSession();
        
        Transaction trns = ses.beginTransaction();
        
        ses.save(p1);
        ses.save(p2);
        ses.save(pan1);
        ses.save(pan2);
        Pan p =ses.get(Pan.class, 1002);
        p.setPanNumber(111111111);
        
        ses.saveOrUpdate(p);
        
        trns.commit();
        
        ses.close();
    }
}
 