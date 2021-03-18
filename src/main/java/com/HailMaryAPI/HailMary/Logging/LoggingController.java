package com.HailMaryAPI.HailMary.Logging;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void clientDoesntExist(String s) {
        this.logger.error("Client's " + s + " doesn't exist");
    }

    public void clientDoesExist(String s) {
        this.logger.error("Client's " + s + " already exists");
    }

    public void unableToUpdateClient(String s) {
        this.logger.error("Failed to update client's " + s);
    }

    public void updateSuccessful(String s) {
        this.logger.info("Updated " + s + " successfully");
    }

    public void clientAddedSuccessfully(String s) {
        this.logger.info("Client's" + s + " was added successfully");
    }

    public void clientRetrievedSuccessfully(String s) {
        this.logger.info("Client's " + s + " was retrieved successfully");
    }

    public void clientDeletedSuccessfully(String s) {
        this.logger.info("Client's " + s + " was deleted successfully");
    }

    public void unableToDeleteClient(String s) {
        this.logger.error("Failed to delete client's " + s);
    }

    public void adminDoesntExist(String s) {
        this.logger.error("Admin's " + s + " doesn't exist");
    }

    public void adminDoesExist(String s) {
        this.logger.error("Admin's " + s + " already exists");
    }

    public void adminRetrievedSuccessfully(String s) {
        this.logger.info("Admin's " + s + " was retrieved successfully");
    }

    public void adminAddedSuccessfully(String s) {
        this.logger.info("Admin's " + s + " was added successfully");
    }

    public void sendingEmail() {
        this.logger.info("Sending email...");
    }

    public void emailSent() {
        this.logger.info("Email was sent successfully");
    }

    public void unableToSendEmail(String s) {
        this.logger.error("Error sending email. " + s);
    }

    public void policyRetrievedSuccessfully(String s) {
        this.logger.info("Policies were retrieved successfully through " + s);
    }

    public void unableToFindPolicy(String s) {
        this.logger.error("No policies were found through " + s);
    }

    public void policyExists() {
        this.logger.error("Policy already exists");
    }

    public void policyAddedSuccessfully() {
        this.logger.info("Policy successfully added");
    }

    public void policyDeletedSuccessfully(String s) {
        this.logger.info("Policy successfully deleted by " + s);
    }
}
