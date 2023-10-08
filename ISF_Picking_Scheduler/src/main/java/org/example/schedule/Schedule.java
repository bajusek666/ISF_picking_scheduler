package org.example.schedule;

import org.example.order.Order;
import org.example.order.OrdersList;
import org.example.pickers.Pickers;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    public ArrayList<Task> create(OrdersList orders, Pickers pickers) {

        ArrayList<Task> schedule = new ArrayList<>();
        HashMap<String, LocalTime> pickersTimeTracker = new HashMap<>();
        ArrayList<String> pickersIds = pickers.getPickers();
        LocalTime pickingStartTime = pickers.getPickingStartTime();
        LocalTime pickingEndTime = pickers.getPickingEndTime();


        //Assigning employees to the Map tracking the progress of time spent on completing orders
        for (String pickerId : pickersIds) {
            pickersTimeTracker.put(pickerId, pickingStartTime);
        }

        //Create a new list with orders sorted from shortest order picking time to longest order picking time
        ArrayList<Order> sortedOrders = new ArrayList<>();
        int numberOfOrders = orders.getOrdersList().size();
        for (int i = 0; i < numberOfOrders; i++) {
            Order quickestOrder = orders.getOrderWithTheShortestPickingTime();
            sortedOrders.add(quickestOrder);
            orders.getOrdersList().remove(quickestOrder);
        }


        int passedOrdersCounter = 0;

        while (!sortedOrders.isEmpty()) {
            for (String pickerId : pickersIds) {
                if (sortedOrders.isEmpty()) {
                    break;
                }
                Order order = sortedOrders.get(0);
                Duration orderPickingTime = order.getPickingTime();
                LocalTime currentPickerTime = pickersTimeTracker.get(pickerId);
                LocalTime currentOrderCompleteByTime = order.getCompleteBy();

                if (currentPickerTime.plus(orderPickingTime).compareTo(pickingEndTime) <= 0 && currentPickerTime.plus(orderPickingTime).compareTo(currentOrderCompleteByTime) <= 0) {
                    passedOrdersCounter = 0;
                    sortedOrders.remove(0);
                    pickersTimeTracker.put(pickerId, currentPickerTime.plus(orderPickingTime));
                    Task task = new Task();
                    task.setOrderId(order.getOrderId());
                    task.setPickerId(pickerId);
                    task.setPickingStartTime(currentPickerTime);
                    schedule.add(task);
                } else {
                    passedOrdersCounter++;
                    if (passedOrdersCounter > pickersIds.size()) {
                        return schedule;
                    }
                }
            }
        }


        return schedule;
    }

    //Algorithm considering the order value field
    public ArrayList<Task> createWithValueOptimization(OrdersList orders, Pickers pickers) {


        ArrayList<Task> schedule = new ArrayList<>();
        HashMap<String, LocalTime> pickersTimeTracker = new HashMap<>();
        ArrayList<String> pickersIds = pickers.getPickers();
        LocalTime pickingStartTime = pickers.getPickingStartTime();
        LocalTime pickingEndTime = pickers.getPickingEndTime();

        for (String pickerId : pickersIds) {
            pickersTimeTracker.put(pickerId, pickingStartTime);
        }



        ArrayList<Order> sortedOrders = new ArrayList<>();
        int numberOfOrders = orders.getOrdersList().size();
        for (int i = 0; i < numberOfOrders; i++) {
            Order order = orders.getOrderWithTheBestValueToTimeRate();
            sortedOrders.add(order);
            orders.getOrdersList().remove(order);
        }


        int passedOrdersCounter = 0;

        while (!sortedOrders.isEmpty()) {
            for (String pickerId : pickersIds) {
                if (sortedOrders.isEmpty()) {
                    break;
                }
                Order order = sortedOrders.get(0);
                Duration orderPickingTime = order.getPickingTime();
                LocalTime currentPickerTime = pickersTimeTracker.get(pickerId);
                LocalTime currentOrderCompleteByTime = order.getCompleteBy();

                if (currentPickerTime.plus(orderPickingTime).compareTo(pickingEndTime) <= 0 && currentPickerTime.plus(orderPickingTime).compareTo(currentOrderCompleteByTime) <= 0) {
                    passedOrdersCounter = 0;
                    sortedOrders.remove(0);
                    pickersTimeTracker.put(pickerId, currentPickerTime.plus(orderPickingTime));
                    Task task = new Task();
                    task.setOrderId(order.getOrderId());
                    task.setPickerId(pickerId);
                    task.setPickingStartTime(currentPickerTime);
                    schedule.add(task);
                } else {
                    passedOrdersCounter++;
                    if (passedOrdersCounter > pickersIds.size()) {
                        return schedule;
                    }
                }
            }
        }


        return schedule;
    }

}
