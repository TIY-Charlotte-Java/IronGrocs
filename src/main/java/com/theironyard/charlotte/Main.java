package com.theironyard.charlotte;

import spark.Spark;

public class Main {

    public static void main(String[] args) {
        String port = System.getenv("PORT");

        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        // https://iron-grocs.herokuapp.com/grocs
        Spark.webSocket("/grocs", GrocWebSocket.class);
        Spark.init();

        Spark.after(((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        }));
    }
}
