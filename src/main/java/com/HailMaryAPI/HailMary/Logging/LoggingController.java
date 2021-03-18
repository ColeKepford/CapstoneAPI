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

    public void unableToUpdateClient() {
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

    public void clientdDeletedSuccessfully() {
        this.logger.info("Client was deleted successfully");
    }

    public void unableToDeleteClient() {
        this.logger.error("Failed to delete client");
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

    public void sendingEmail() {
        this.logger.info("Sending email...");
    }

    public void emailSent() {
        this.logger.info("Email was sent successfully");
    }

    public void unableToSendEmail() {
        this.logger.error("Error sending email");
    }

    public void policyRetrievedSuccessfully() {
        this.logger.info("Policies were retrieved successfully");
    }

    public void unableToFindPolicy() {
        this.logger.error("No policies were found");
    }

    public void policyExists() {
        this.logger.error("Policy already exists");
    }

    public void policyAddedSuccessfully() {
        this.logger.info("Policy successfully added");
    }

    public void policyDeletedSuccessfully() {
        this.logger.info("Policy successfully deleted");
    }
}
