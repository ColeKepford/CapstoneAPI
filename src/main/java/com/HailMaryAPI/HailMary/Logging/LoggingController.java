package com.HailMaryAPI.HailMary.Logging;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void clientDoesntExist() {
        this.logger.error("Client doesnt exist");
    }

    public void clientDoesExist() {
        this.logger.error("Client already exists");
    }

    public void unableToUpdate() {
        this.logger.error("Failed to update client");
    }

    public void updateSuccessfull() {
        this.logger.info("Updated successfully");
    }

    public void clientAddedSuccessfully() {
        this.logger.info("Client was added successfully");
    }

    public void clientRetrivedSuccessfully() {
        this.logger.info("Client was retrived successfully");
    }

    public void adminDoesntExist() {
        this.logger.error("Admin doesnt exist");
    }

    public void adminDoesExist() {
        this.logger.error("Admin already exists");
    }

    public void adminRetrivedSuccessfully() {
        this.logger.info("Admin was retrived successfully");
    }

    public void adminAddedSuccessfully() {
        this.logger.info("Admin was added successfully");
    }
}
