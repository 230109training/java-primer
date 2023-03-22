package com.revature.utility;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            registryBuilder.applySetting("hibernate.connection.driver_class", "org.postgresql.Driver");
            registryBuilder.applySetting("hibernate.connection.url", "jdbc:postgresql://database-1.cifwcr7ybkhx.us-east-1.rds.amazonaws.com:5432/postgres");
            registryBuilder.applySetting("hibernate.connection.username", "postgres");
            registryBuilder.applySetting("hibernate.connection.password", "password");
            registryBuilder.applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            registryBuilder.applySetting("hibernate.hbm2ddl.auto", "validate");
            // hbm2ddl.auto options
            // 1. validate: Hibernate will validate the existing DB structure against the entity mappings (annotations)
            //              If there are any discrepancies, an exception will be thrown and the application will not start
            // 2. update: Hibernate will update the existing database schema based on the entity mappings, discarding any
            //              existing schema and data
            // 3. create: Hibernate will create a new database schema based on the entity mappings, discarding any existing
            //              schema and data
            // 4. create-drop: Hibernate will create a new database schema based on the entity mappings, just like with the "create"
            //              option. However, when SessionFactory is closed, Hibernate will also drop the entire schema

            MetadataSources sources = new MetadataSources(registryBuilder.build());
            sessionFactory = sources
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Reimbursement.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }

        return sessionFactory;
    }

}
