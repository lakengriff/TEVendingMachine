package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    File IncomeLog = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\src\\main\\resources\\Log.txt");
    boolean append = IncomeLog.exists();

    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    String dateTime = LocalDateTime.now().format(formatTime);

    public void log(String loggedAction) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(IncomeLog, append))) {
            writer.println(dateTime + " " + loggedAction);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        //num of transactions
    }
}
