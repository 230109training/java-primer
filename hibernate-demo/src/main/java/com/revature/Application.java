package com.revature;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.utility.HibernateUtility;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Application {

    public static void main(String[] args) {
//        insertNewUsers();
//        retrieveUserByPK();
//        retrieveAllUsers();
//        populateReimbursements();
//        getAllReimbursementsOfAParticularUser();
//        getAllReimbursementsOfAParticularUser_number_2();
        modifyReimbursement2Information();
    }

    public static void modifyReimbursement2Information() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction(); // start the transaction

        // Persistent Reimbursement object
        Reimbursement reimb = session.find(Reimbursement.class, 2);
        reimb.setStatus("pending"); // change

        tx.commit(); // commit the transaction

        session.close();
    }

    public static void getAllReimbursementsOfAParticularUser_number_2() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        List<Reimbursement> reimbursementsThatBelongToJohn = session
                .createQuery("SELECT r FROM User u JOIN Reimbursement r WHERE u.username = ?1", Reimbursement.class)
                .setParameter(1, "test123")
                .getResultList();

        System.out.println(reimbursementsThatBelongToJohn);

        session.close();
    }

    public static void getAllReimbursementsOfAParticularUser() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        User john = session.find(User.class, "test123");
        // HQL does not care about the database at all
        // The namings that you need to use are the class names of the entities and the field variable names in those classes
        List<Reimbursement> reimbursementsThatBelongToJohn = session.createQuery("FROM Reimbursement r WHERE r.submitter = ?1", Reimbursement.class)
                .setParameter(1, john)
                .getResultList();

        System.out.println(reimbursementsThatBelongToJohn);

        session.close();
    }

    public static void getSubmitterOfReimbursement() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        Reimbursement reimb = session.find(Reimbursement.class,2); // get reimbursement
        User userThatSubmittedReimbursement = reimb.getSubmitter(); // use getSubmitter on the reimbursement

        System.out.println(userThatSubmittedReimbursement);
    }

    public static void populateReimbursements() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        User john = session.find(User.class, "test123");

        Transaction tx = session.beginTransaction();

        Reimbursement reimb1 = new Reimbursement(0, "Team building lunch", 30.5, "pending", john);
        session.persist(reimb1);

        tx.commit();

        session.close();
    }

    public static void retrieveAllUsers() {
        // Require HQL (Hibernate Query Language)
        Session session = HibernateUtility.getSessionFactory().openSession();

        // FROM User u <- User is the name of the class, not the table in the database
        // This is because HQL uses the actual entity class itself, not the names in the database
        List<User> users = session.createQuery("FROM User u", User.class).getResultList();
        for (User u : users) {
            System.out.println(u);
        }

        session.close();
    }

    public static void retrieveUserByPK() {
        Session session = HibernateUtility.getSessionFactory().openSession();

        User user = session.find(User.class,"test123");
        System.out.println(user);

        User user2 = session.find(User.class, "testing12345");
        System.out.println(user2);
    }

    public static void insertNewUsers() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user1 = new User("test123",
                "password123",
                "John",
                "Doe",
                "john_doe@email.com",
                30,
                "employee");

        User user2 = new User("testing12345", "test123", "Test", "Testing", "test@test.com", 50, "finance_manager");

        session.persist(user2);
        session.persist(user1); // INSERTS user into users table
        tx.commit();
        // Keep in mind, that once you commit a transaction (or rollback a transaction), you must
        // create a new transaction if there's any additional modifications that you would like to make
        tx = session.beginTransaction();
        // More Hibernate code here
        tx.commit();

        session.close();
    }

}
