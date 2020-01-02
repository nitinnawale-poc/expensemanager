/**
 * 
 */
package com.mobiliya.expensemanager.service.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageExecutorService.
 *
 * @author Nitin
 */
@Service
public class MessageExecutorService {

    /** The logger. */
    Logger logger = LoggerFactory.getLogger(MessageExecutorService.class);

    /**
     * Prints the message on console.
     */
    public String printMessageOnConsole() {
        String str = "Started";
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Please check your Email");
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
        return str;
    }

}
