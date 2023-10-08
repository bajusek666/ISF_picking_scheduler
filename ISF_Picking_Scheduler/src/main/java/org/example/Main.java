package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.converter.Converter;
import org.example.jsonParsing.Json;
import org.example.order.Order;
import org.example.order.OrdersList;
import org.example.pickers.Pickers;
import org.example.schedule.Schedule;
import org.example.schedule.Task;
import org.example.stringToTimeConverters.OrderString;
import org.example.stringToTimeConverters.PickersString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String storeConfigurationFile = args[0];
        String ordersFile = args[1];
        String jsonStoreConfiguration = readFileAsString(storeConfigurationFile);
        String jsonOrders = readFileAsString(ordersFile);

        PickersString pickersString = pickersStringFromJsonFile(jsonStoreConfiguration);
        OrderString[] ordersString = ordersStringListFromJsonFile(jsonOrders);
        Converter converter = new Converter();

        OrdersList orders = converter.convertOrdersStringListToOrdersList(ordersString);
        Pickers pickers = converter.convertPickersStringToPickers(pickersString);

        // Exercise 1 = results

        Schedule schedule = new Schedule();
        ArrayList<Task> tasks = schedule.create(orders, pickers);
        for (Task task : tasks) {
            System.out.println(task);
        }

        orders = converter.convertOrdersStringListToOrdersList(ordersString);
        pickers = converter.convertPickersStringToPickers(pickersString);

        //Exercise 2 - results

        System.out.println("\n<Second iteration, value-based algorithm>\n");

        Schedule optimizedSchedule = new Schedule();
        ArrayList<Task> optimizedTasks = optimizedSchedule.createWithValueOptimization(orders,pickers);
        for (Task task: optimizedTasks) {
            System.out.println(task);
        }


    }

    public static Pickers pickersFromJsonFile(String jsonStoreConfiguration) throws IOException {
        JsonNode pickersNode = Json.parse(jsonStoreConfiguration);
        Pickers pickers = Json.fromJsonToObject(pickersNode, Pickers.class);
        return pickers;
    }

    public static OrdersList ordersFromJsonFile(String jsonOrders) throws IOException {
        JsonNode ordersNode = Json.parse(jsonOrders);
        OrdersList ordersList = Json.fromJsonToObject(ordersNode, OrdersList.class);
        return ordersList;
    }

    public static PickersString pickersStringFromJsonFile(String jsonStoreConfiguration) throws IOException {
        JsonNode pickersStringNode = Json.parse(jsonStoreConfiguration);
        PickersString pickersString = Json.fromJsonToObject(pickersStringNode, PickersString.class);
        return pickersString;
    }

    public static OrderString[] ordersStringListFromJsonFile(String jsonOrders) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        OrderString[] orders = mapper.readValue(jsonOrders, OrderString[].class);
        return orders;
    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static int valueToPickingTimeRate(Order order) {
        int valueToPickingTimeRate = order.getOrderValue().intValue() * (int) order.getPickingTime().getSeconds();
        return valueToPickingTimeRate;
    }

}