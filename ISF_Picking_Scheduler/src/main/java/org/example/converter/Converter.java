package org.example.converter;


import org.example.order.Order;
import org.example.order.OrdersList;
import org.example.pickers.Pickers;
import org.example.stringToTimeConverters.OrderString;
import org.example.stringToTimeConverters.OrdersStringList;
import org.example.stringToTimeConverters.PickersString;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Converter {

    public static OrdersList convertOrdersStringListToOrdersList(OrderString[] ordersStringArray){
        OrdersList orders = new OrdersList();

        for (int i = 0; i < ordersStringArray.length; i++) {
            Order order = new Order();
            String orderId = ordersStringArray[i].getOrderId();
            BigDecimal orderValue = ordersStringArray[i].getOrderValue();
            Duration pickingTime = Duration.parse(ordersStringArray[i].getPickingTime());
            LocalTime completeBy = LocalTime.parse(ordersStringArray[i].getCompleteBy());

            order.setOrderId(orderId);
            order.setOrderValue(orderValue);
            order.setPickingTime(pickingTime);
            order.setCompleteBy(completeBy);

            orders.getOrdersList().add(order);
        }

        return orders;
    }

    public static Pickers convertPickersStringToPickers(PickersString pickersString){

        Pickers pickers = new Pickers();

        pickers.setPickers(pickersString.getPickers());
        pickers.setPickingStartTime(LocalTime.parse(pickersString.getPickingStartTime()));
        pickers.setPickingEndTime(LocalTime.parse(pickersString.getPickingEndTime()));

        return pickers;
    }

}
