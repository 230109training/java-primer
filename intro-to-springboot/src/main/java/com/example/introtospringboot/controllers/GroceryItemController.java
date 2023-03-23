package com.example.introtospringboot.controllers;

import com.example.introtospringboot.Car;
import com.example.introtospringboot.dto.MessageDTO;
import com.example.introtospringboot.exceptions.InvalidParameterException;
import com.example.introtospringboot.model.GroceryItem;
import com.example.introtospringboot.services.GroceryItemService;
import org.aspectj.bridge.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@RestController
public class GroceryItemController {

    private GroceryItemService groceryItemService;

    private Car car;

    // Dependency Injection
    public GroceryItemController(GroceryItemService groceryItemService, Car car) {
        this.groceryItemService = groceryItemService;
        this.car = car;
    }

    @PostMapping(path = "/grocery-items")
    public ResponseEntity<MessageDTO> addGroceryItem(@RequestBody GroceryItem item) {

        System.out.println(car);

        try {
            groceryItemService.addGroceryItem(item);
            return ResponseEntity.ok(new MessageDTO("Item successfully added"));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));
        }

    }

    @GetMapping(path = "/grocery-items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems(@RequestParam(name = "quantityLessThan", required=false) String quantityLessThan) {
        if (quantityLessThan != null) {
            int intQuantityLessThan = Integer.parseInt(quantityLessThan);
            List<GroceryItem> items = groceryItemService.getAllItemsQuantityLessThan(intQuantityLessThan);

            return ResponseEntity.ok(items);
        }

        return ResponseEntity.ok(groceryItemService.getAllItems());
    }

}
