package org.example.jsonParsing;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.jsonParsing.testClasses.Dog;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    String jsonTestString = "{ \"pickingStartTime\": \"06:00\" }";
    String jsonDogString = "{ \"name\": \"fifek\" }";
    String jsonOrderExample = "{\n" +
            "\"orderId\": \"order-2\",\n" +
            "\"orderValue\": \"82.40\",\n" +
            "\"pickingTime\": \"PT17M\",\n" +
            "\"completeBy\": \"14:00\"\n" +
            "}";

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(jsonTestString);
        assertEquals(node.get("pickingStartTime").asText(),"06:00");

    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(jsonDogString);
        Dog fifek = Json.fromJsonToObject(node, Dog.class);

        assertEquals(fifek.name, "fifek");
    }

//    @Test
//    void fromJsonOrders() throws JsonProcessingException {
//        JsonNode node = Json.parse(jsonOrderExample);
//        TestOrder order = Json.fromJsonToObject(node, TestOrder.class);
//
//        assertEquals(order.getOrderId(),"order-2");
//        assertEquals(order.getOrderValue(), 82.40);
//        assertEquals(order.getCompleteBy(), "14:00");
//
//    }
}