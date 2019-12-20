package com.mobiliya.expensemanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class ExpensemanagerApplication.
 *
 * @author Nitin
 */
@SpringBootApplication
@EnableJpaRepositories
public class ExpensemanagerApplication {

/** The logger. */
static Logger logger = LoggerFactory.getLogger(ExpensemanagerApplication.class);

/**
 * The main method.
 *
 * @param args the arguments
 */
public static void main(String[] args) {
logger.info("Application Started : " + args);
SpringApplication.run(ExpensemanagerApplication.class, args);
}

}
