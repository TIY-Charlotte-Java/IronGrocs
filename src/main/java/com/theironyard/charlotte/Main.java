package com.theironyard.charlotte;

import spark.Spark;

public class Main {

    public static void main(String[] args) {
        Spark.after(((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        }));

        Spark.webSocket("/grocs", GrocWebSocket.class);
        Spark.init();
    }
}
