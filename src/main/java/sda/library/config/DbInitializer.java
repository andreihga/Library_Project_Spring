package sda.library.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbInitializer {

//    we get session, sessionFactory and transaction 'hibernate' library;

    SessionFactory sessionFactory;
    public Session session;
    Transaction transaction;

    public DbInitializer(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public void openSessionAndTransaction(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void closeSessionAndTransaction(){
        transaction.commit();
        session.close();
    }
}
