package com.example.introtospringboot.services;

import com.example.introtospringboot.dao.GroceryItemDao;
import com.example.introtospringboot.exceptions.InvalidParameterException;
import com.example.introtospringboot.model.GroceryItem;
import org.springframework.scripting.groovy.GroovyObjectCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroceryItemService {

    private GroceryItemDao groceryItemDao;

    // Dependency injection
    public GroceryItemService(GroceryItemDao groceryItemDao) {
        this.groceryItemDao = groceryItemDao;
    }

    // Transactional by default will wrap the code in the method that is annotated into a transaction
    // while also wrapping all of the code in any method called by the annotated method into the transaction
    // For example, if addGroceryItem had multiple calls to the DAO layer, all of those DAO layer method calls
    // Would be part of the same transaction
    // Ex: Banking application
    //  -> BankAccountService transferMoney() method
    //              -> decreaseBalance
    //              -> increaseBalance
    // By annotating the BankAccountService transferMoney method with @Transactional,
    //      both the decreaseBalance and increaseBalance methods are treated as part of a single transaction
    // Transaction: All or nothing
    @Transactional
    public void addGroceryItem(GroceryItem item) throws InvalidParameterException {
        if (item.getQuantity() <= 0) {
            throw new InvalidParameterException("Quantity must be greater than 0");
        }

        groceryItemDao.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return groceryItemDao.findAll();
    }

    public List<GroceryItem> getAllItemsQuantityLessThan(int quantity) {
        return groceryItemDao.findByQuantityLessThan(quantity);
    }

}
