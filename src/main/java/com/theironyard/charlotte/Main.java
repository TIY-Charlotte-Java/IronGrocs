package com.theironyard.charlotte;

import spark.Spark;

public class Main {

    public static void main(String[] args) {
        // https://iron-grocs.herokuapp.com/grocs
        Spark.webSocket("/grocs", GrocWebSocket.class);
        Spark.init();

        Spark.after(((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        }));
    }
}
