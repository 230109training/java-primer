package com.revature;

import com.revature.model.Circle;
import com.revature.model.Rectangle;
import com.revature.model.Shape;
import com.revature.model.Triangle;

import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Shape s = new Circle(10);


        // Shape s
        System.out.println(s.calculateArea());
    }

}
