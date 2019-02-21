package com.ibrahim.xspeedit;

import org.junit.Test;

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

}