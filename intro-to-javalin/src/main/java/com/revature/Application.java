package com.revature;

import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // Potentially (since query parameters are optional), extracting data
        // from query parameter "test"
        app.get("/hello", (ctx) -> {

            String testQueryParameter = ctx.queryParam("test");
            if (testQueryParameter != null) {
                ctx.json(new MessageDTO("Query param 'test' value is " + testQueryParameter));
                return;
            }

            ctx.json(new MessageDTO("Hello World"));
        });

        // Extracting data from path parameter
        app.get("/hello/{id}", (ctx) -> {
           String id = ctx.pathParam("id");
           ctx.json(new MessageDTO("Sent id " + id + " as a path parameter"));
        });

        // Extracting data from request body
        app.post("/people", (ctx) -> {
            PersonDTO dto = ctx.bodyAsClass(PersonDTO.class);

            ctx.json(new MessageDTO("Successfully received data. firstName is " + dto.getFirstName() + ", " +
                    "lastName is " + dto.getLastName() + ", age is " + dto.getAge()));
        });

        app.start(8080);
    }

}
