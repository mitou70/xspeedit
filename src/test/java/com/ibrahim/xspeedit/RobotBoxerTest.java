package com.ibrahim.xspeedit;

import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mitou on 20/02/19.
 */
public class RobotBoxerTest {

    public static final String GIVEN_ITEMS = "163841689525773";
    public static final String EXPECTED_UNOPTIMIZED_ITEMS = "163/8/41/6/8/9/52/5/7/73";

    @Test
    public void should_return_wraped_boxes() {
        //WHEN
        String boxedItems = RobotBoxer.boxItems(GIVEN_ITEMS);
        //THEN
        assertThat(boxedItems).isEqualTo(EXPECTED_UNOPTIMIZED_ITEMS);
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

}