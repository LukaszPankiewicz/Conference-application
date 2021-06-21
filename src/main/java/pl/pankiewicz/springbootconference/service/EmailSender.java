package pl.pankiewicz.springbootconference.service;


import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Service
public class EmailSender {

    public void sendEmail(String to) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/fileName.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(LocalDateTime.now());
        printWriter.printf(to);
        printWriter.println("Your reservation is confirmed");
        printWriter.close();
    }
}
