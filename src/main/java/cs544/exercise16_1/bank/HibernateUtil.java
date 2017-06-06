package cs544.exercise16_1.bank;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory ;
	static {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		try{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Throwable ex){
			System.err.println(ex);
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
