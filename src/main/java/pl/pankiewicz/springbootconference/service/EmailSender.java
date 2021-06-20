package pl.pankiewicz.springbootconference.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class EmailSender {

    private String mailTo;

    public EmailSender(String mailTo) {
        this.mailTo = mailTo;
    }

    LocalDate lt = LocalDate.now();

    public void mailSender()
            throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/fileName.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(lt);
        printWriter.printf(mailTo);
        printWriter.println("Your reservation is confirmed");
        printWriter.close();
    }
}
