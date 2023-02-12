package com.techelevator.view;

import com.techelevator.Candy;
import com.techelevator.Drink;
import com.techelevator.Gum;
import com.techelevator.Chip;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MakeSoundTest {


//    public Candy(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {

    @Test
    public void get_candy_sound_when_ordered() {
        Candy candy = new Candy("B1", "Moonpie", BigDecimal.valueOf(1.80), "Candy", 5);

        //Arrange
        String expected = "Munch Munch, Mmm Mmm Good!";

        //Act
        String actual = candy.getSound();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void get_drink_sound_when_ordered() {
        Drink drink = new Drink("C1", "Cola", BigDecimal.valueOf(1.25), "Drink", 5);

        //Arrange
        String expected = "Glug Glug, Chug Chug!";

        //Act
        String actual = drink.getSound();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void get_gum_sound_when_ordered() {
        Gum gum = new Gum("D1", "U-Chews", BigDecimal.valueOf(0.85), "Gum", 5);

        //Arrange
        String expected = "Chew Chew, Pop!";

        //Act
        String actual = gum.getSound();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void get_chip_sound_when_ordered() {
        Chip chip = new Chip("A1", "Potato Crisps", BigDecimal.valueOf(3.05), "Chip", 5);

        //Arrange
        String expected = "Crunch Crunch, It's Yummy!";

        //Act
        String actual = chip.getSound();

        //Assert
        assertEquals(expected, actual);
    }
}
