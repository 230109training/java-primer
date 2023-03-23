package com.example.introtospringboot.dao;

import com.example.introtospringboot.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/*
    SPRING DATA APPROACH
 */
// When using Spring Data, we create an interface that extends another interface
// Behind the scenes, Spring Data JPA will automatically configure and implement many methods
// that can be used "out of the box"
@Repository
public interface GroceryItemDao extends JpaRepository<GroceryItem, Integer> {

    @Query("FROM GroceryItem g WHERE g.quantity < :amount")
    public abstract List<GroceryItem> findByQuantityLessThan(int amount);
    
    public abstract List<GroceryItem> findByQuantityGreaterThan(int amount);

    @Query("FROM GroceryItem g WHERE g.quantity > :lower AND g.quantity < :higher")
    public abstract List<GroceryItem> findByQuantityBetween(int lower, int higher);

    public abstract List<GroceryItem> findByNameStartingWith(String prefix);
    public abstract List<GroceryItem> findByNameEndingWith(String suffix);

    // Custom logic
    // Sometimes you will need to define custom logic that doesn't fit into anything
    // that Spring Data conventionally recognizes for method names
    // In that case, define a method in the interface, and use the @Query("...") annotation
    // In the @Query annotation, you would define the JPQL (Java Persistence Query Language) query that you need to use
    // JPQL is very similar to HQL (which we saw in the Hibernate demo)


}

/*
    REGULAR JPA APPROACH BELOW
 */
// This approach is using the Java Persistence API, which sits on top of Hibernate
// In this particular implementation of the GroceryItemDao, we are only making use of JPA -> Hibernate -> JDBC
// but we're not using any Spring Data features
// Spring Data is an abstraction on top of JPA, that even further simplifies the process of using ORM technologies
//@Repository
//public class GroceryItemDao {
//
//    private EntityManager em;
//
//    // Dependency injection
//    public GroceryItemDao(EntityManager em) {
//        this.em = em;
//    }
//
//    @Transactional
//    public void addItem(GroceryItem item) {
//        em.persist(item);
//    }
//
//}


