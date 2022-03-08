package hibernatemapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome Hibernate");

		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Employees e = new Employees();
		Employees e1 = new Employees();
		Employees e2 = new Employees();

		e.setEid(1);
		e.setEname("Amit");
		e.setSalary("400000");
		
		e1.setEid(2);
		e1.setEname("Amit");
		e1.setSalary("400000");
		
		e2.setEid(3);
		e2.setEname("Amit");
		e2.setSalary("400000");
		
		List<Employees> list = new ArrayList<Employees>();
		list.add(e);
		list.add(e1);
		list.add(e2);
		
		

		Department d = new Department();

		d.setDid(2);
		d.setDname("CSE");

		e.setDepartment(d);
		
		d.setEmployees(list);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(e);
		s.save(d);

		tx.commit();
		s.close();
		factory.close();
	}
}
