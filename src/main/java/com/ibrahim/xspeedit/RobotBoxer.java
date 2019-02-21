package com.ibrahim.xspeedit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.logging.log4j.util.Strings.isBlank;

public class RobotBoxer {

    public static String boxItems(String itemsAsString) {
        List<Integer> itemsToBox = convertStringToListOfIntegers(itemsAsString);
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for (Integer currentItem : itemsToBox) {
            if (currentItem + counter <= 10) {
                stringBuilder.append(currentItem);
                counter += currentItem;
            } else {
                stringBuilder.append("/").append(currentItem);
                counter = currentItem;
            }
        }
        String boxedItems = stringBuilder.toString();
        return boxedItems;
    }

    protected static List<Integer> convertStringToListOfIntegers(String itemsAsString) {
        if(isBlank(itemsAsString))
            return Collections.emptyList();
        List<Integer> itemsAsIntegers = Stream.of(itemsAsString.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return itemsAsIntegers;
    }
}
