package com.ibrahim.xspeedit;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.logging.log4j.util.Strings.isBlank;

public class RobotBoxer {

    public static final String ITEM_SEPARATOR = "/";

    public static String boxItems(String itemsAsString) {
        List<Integer> itemsToBox = convertStringToListOfIntegers(itemsAsString);
        StringBuilder boxedItems = new StringBuilder();
        int counter = 0;
        for (Integer currentItem : itemsToBox) {
            if (currentItem + counter <= 10) {
                boxedItems.append(currentItem);
                counter += currentItem;
            } else {
                boxedItems.append(ITEM_SEPARATOR).append(currentItem);
                counter = currentItem;
            }
        }
        String boxedItemsAsAString = boxedItems.toString();
        return boxedItemsAsAString;
    }

    /**
     * This is one possible implementation of an optimized boxing
     *  steps
     *      step 1 : split the list of items into two lists (the first one from one to 5 and the second one from 6 to 9
     *      step 2 : merge the two lists and alternate to elements on order to put the higher element close to small ones
     *      step 3 : apply the simple boxItems algorithm
     * @return String of boxed items optimally
     */

    public static String convertToBoxesOptimal(String itemsAsString) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> itemsAsList = convertStringToListOfIntegers(itemsAsString);
        Collection<List<Integer>> SplittedListToBox = itemsAsList.stream().sorted().collect(Collectors.partitioningBy(o -> o > 5)).values();

        if (SplittedListToBox.size() == 2) {
            List<Integer> lowElements = new ArrayList<>(SplittedListToBox).get(0);
            List<Integer> highElements = new ArrayList<>(SplittedListToBox).get(1);
            Collections.reverse(highElements);
            List<Integer> mergedList = mergeAlternatingElements(lowElements, highElements);
            mergedList.forEach(stringBuilder::append);
            String boxedItems = boxItems(stringBuilder.toString());
            return boxedItems;
        } else {
            return Strings.EMPTY;
        }
    }

    protected static List<Integer> mergeAlternatingElements(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int size = Math.max(a.size(), b.size());

        for (int i = 0; i < size; i++) {
            if (i < a.size()) result.add(a.get(i));
            if (i < b.size()) result.add(b.get(i));
        }
        return result;
    }

    protected static List<Integer> convertStringToListOfIntegers(String itemsAsString) {
        if (isBlank(itemsAsString))
            return Collections.emptyList();

        List<Integer> itemsAsIntegers = Stream.of(itemsAsString.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return itemsAsIntegers;
    }
}
