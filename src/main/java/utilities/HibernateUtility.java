package utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtility {

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private HibernateUtility() {
        // Private constructor to prevent instantiation
    }

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            // Create the EntityManagerFactory from persistence.xml
            return Persistence.createEntityManagerFactory("ucdfsunit");
        } catch (Throwable ex) {
            // Log the exception
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

