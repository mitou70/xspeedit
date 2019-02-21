package com.ibrahim.xspeedit;

import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mitou on 20/02/19.
 */
public class RobotBoxerTest {

    public static final String GIVEN_ITEMS = "163841689525773";
    public static final String GIVEN_ITEMS2 = "111756329124581597532486263841689525773";
    public static final String EXPECTED_UNOPTIMIZED_ITEMS = "163/8/41/6/8/9/52/5/7/73";
    public static final String EXPECTED_UNOPTIMIZED_ITEMS2 = "1117/5/63/2/91/24/5/81/5/9/7/532/4/8/62/63/8/41/6/8/9/52/5/7/73";
    public static final String EXPECTED_OPTIMIZED_ITEMS = "19/18/28/37/37/46/5/6/5";
    public static final String EXPECTED_OPTIMIZED_ITEMS2 = "19/19/19/181/81/82/82/72/72/72/73/63/63/63/64/44/55/55/55";


    @Test
    public void should_return_wrapped_boxes() {
        //WHEN
        String boxedItems = RobotBoxer.boxItems(GIVEN_ITEMS);
        //THEN
        assertThat(boxedItems).isEqualTo(EXPECTED_UNOPTIMIZED_ITEMS);
    }

    @Test
    public void should_return_wrapped_boxes2() {
        //WHEN
        String boxedItems = RobotBoxer.boxItems(GIVEN_ITEMS2);
        //THEN
        assertThat(boxedItems).isEqualTo(EXPECTED_UNOPTIMIZED_ITEMS2);
    }

    @Test
    public void should_return_an_empty_list_for_an_empty_string() {
        //WHEN
        String boxedItems = RobotBoxer.boxItems(Strings.EMPTY);
        //THEN
        assertThat(boxedItems).isEqualTo(Strings.EMPTY);
    }

    @Test
    public void should_return_an_empty_list_when_items_are_null() {
        //WHEN
        String boxedItems = RobotBoxer.boxItems(null);
        //THEN
        assertThat(boxedItems).isEqualTo(Strings.EMPTY);
    }

    @Test
    public void should_return_wrapped_boxes_optimal() {
        //WHEN
        String boxedItems = RobotBoxer.convertToBoxesOptimal(GIVEN_ITEMS);
        //THEN
        assertThat(boxedItems).isEqualTo(EXPECTED_OPTIMIZED_ITEMS);
    }

    @Test
    public void should_return_wrapped_boxes_optimal2() {
        //WHEN
        String boxedItems = RobotBoxer.convertToBoxesOptimal(GIVEN_ITEMS2);
        //THEN
        assertThat(boxedItems).isEqualTo(EXPECTED_OPTIMIZED_ITEMS2);
    }

    @Test
    public void should_return_an_empty_list_when_empty_string_and_calling_optimal_boxing() {
        //WHEN
        String boxedItems = RobotBoxer.convertToBoxesOptimal(Strings.EMPTY);
        //THEN
        assertThat(boxedItems).isEqualTo(Strings.EMPTY);
    }

    @Test
    public void should_return_an_empty_list_when_items_are_null_and_calling_optimal_boxing() {
        //WHEN
        String boxedItems = RobotBoxer.convertToBoxesOptimal(null);
        //THEN
        assertThat(boxedItems).isEqualTo(Strings.EMPTY);
    }

}