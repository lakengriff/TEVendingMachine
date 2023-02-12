package com.techelevator.view;

import com.techelevator.Balance;
import com.techelevator.Inventory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class MakeChangeTest {



    @Test
    public void coins_returned_given_non_whole_dollar_amount(){
        Balance balance = new Balance();
        //Arrange
        double g = 4.20;
        BigDecimal balanceTest = new BigDecimal(g).setScale(2, RoundingMode.HALF_DOWN);
        String expected = "Here's your change! 16 quarters, 2 dimes, 0 nickels.";
        //Act
        String actual = balance.makeChange(balanceTest);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void coins_returned_given_whole_dollar_amount(){
        Balance balance = new Balance();
        //Arrange
        double g = 2.00;
        BigDecimal balanceTest = new BigDecimal(g).setScale(2, RoundingMode.HALF_DOWN);
        String expected = "Here's your change! 8 quarters, 0 dimes, 0 nickels.";
        //Act
        String actual = balance.makeChange(balanceTest);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void balance_returned_equals_0_dollars(){
        Balance balance = new Balance();
        //Arrange

        BigDecimal balanceTest = new BigDecimal(0.00);
        String expected = "Here's your change! 0 quarters, 0 dimes, 0 nickels.";
        //Act
        String actual = balance.makeChange(balanceTest);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void balance_returned_one_of_each_coin_singular_nouns(){
        Balance balance = new Balance();
        //Arrange
        double g = 0.40;
        BigDecimal balanceTest = new BigDecimal(g).setScale(2, RoundingMode.HALF_DOWN);
        String expected = "Here's your change! 1 quarter, 1 dime, 1 nickel.";
        //Act
        String actual = balance.makeChange(balanceTest);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void balance_is_negative(){          //This case would not occur - balance cannot go below $0
        Balance balance = new Balance();

        //Arrange
        BigDecimal balanceTest = new BigDecimal(-1.00);
        String expected = "Your balance is negative?! Quick, add more money!";

        //Act
        String actual = balance.makeChange(balanceTest);

        //Assert
        assertEquals(expected, actual);
    }
}
