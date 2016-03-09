package com.hwang.min81.fullcount.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by min on 2016. 3. 9..
 */
public class PlayerTest {

    @Test
    public void testGivenNameWithSpaceAtTheBeginningAndTheEnd_WhenSettingAndGettingName_ThenReturnWithNoSpace() {
        Player player = new Player();
        String nameWithSpace = " name with space ";

        player.setName(nameWithSpace);

        assertEquals("name with space", player.getName());
    }

}