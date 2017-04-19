package com.theironyard.charlotte;

import spark.Spark;

public class Main {

    public static void main(String[] args) {
        Spark.webSocket("/grocs", GrocWebSocket.class);
        Spark.init();
    }
}
