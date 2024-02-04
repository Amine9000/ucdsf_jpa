package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.User;
import interfaces.UserDaoOps;
import utilities.HibernateUtility;

public class UserDao implements UserDaoOps {

	@Override
	public void save(User user) {
		EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Get the EntityManager
            entityManager = HibernateUtility.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Save or update the entity
            entityManager.persist(user);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
	}

}
