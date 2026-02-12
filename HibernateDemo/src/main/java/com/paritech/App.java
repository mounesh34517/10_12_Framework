package com.paritech;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Product p1=new Product();
    	
    	Session session=Util.getSF().openSession();
    	Transaction tx=session.beginTransaction();
    	String hql="delete from Product  where pid=:id";
    	
    	Query q= session.createQuery(hql);
//    	q.setParameter("pr", 17000.00);
    	q.setParameter("id", 2);
    	
    	int rows=q.executeUpdate();
    	tx.commit();
    	System.out.println(rows+"row/rows are updated");
//    	List<Product> list=q.getResultList();
//    	System.out.println(list);
    	
    	
    	
    	
//        Person p1=new Person();
//        p1.setPid(4);
//        p1.setPname("Nithish CK");
//        p1.setAddress("Tirupati");
//        p1.setAge(26);
//        
////        savePerson(p1);
////        updatePerson(p1);
//       Person per= getPerson(4);
//       deletePerson(per);
//        
//        
//       System.out.println(per);
    }
    public static void deletePerson(Person p) {
    	try {
        	Session session=Util.getSF().openSession();
        	Transaction tx=session.beginTransaction();
        	
        	session.remove(p);
        	tx.commit();
        	System.out.println("Person Data Deleted....");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    
    public static void updatePerson(Person p) {
    	try {
        	Session session=Util.getSF().openSession();
        	Transaction tx=session.beginTransaction();
        	
        	session.merge(p);
        	tx.commit();
        	System.out.println("Person Data Updated....");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    
    public static Person getPerson(int id) {
    	
    	Person p;
    	
    		Session session=Util.getSF().openSession();
//    		Transaction tx=session.beginTransaction();
    		p=session.find(Person.class, id);
    		return p;
    		
    	
    }
    public static void savePerson(Person p) {
    	try {
        	Session session=Util.getSF().openSession();
        	Transaction tx=session.beginTransaction();
        	
        	session.persist(p);
        	tx.commit();
        	System.out.println("Person Data inserted..");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}





















