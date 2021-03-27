package com.HailMaryAPI.HailMary.Logging;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void clientDoesntExist(String s) {
        this.logger.error(s);
    }

    public void clientDoesExist(String s) {
        this.logger.error(s);
    }

    public void unableToUpdateClient(String s) {
        this.logger.error(s);
    }

    public void updateSuccessful(String s) {
        this.logger.info(s);
    }

    public void clientAddedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void clientRetrievedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void clientDeletedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void unableToDeleteClient(String s) {
        this.logger.error(s);
    }

    public void adminDoesntExist(String s) {
        this.logger.error(s);
    }

    public void adminDoesExist(String s) {
        this.logger.error(s);
    }

    public void adminRetrievedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void adminAddedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void sendingEmail(String s) {
        this.logger.info(s);
    }

    public void emailSent(String s) {
        this.logger.info(s);
    }

    public void unableToSendEmail(String s) {
        this.logger.error(s);
    }

    public void policyRetrievedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void unableToFindPolicy(String s) {
        this.logger.error(s);
    }

    public void policyExists(String s) {
        this.logger.error(s);
    }

    public void policyAddedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void policyDeletedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void summaryDoesntExist(String s) {
        this.logger.error(s);
    }

    public void summaryRetrievedSuccessfully(String s) {
        this.logger.info(s);
    }

    public void summaryDoesExist(String s) {
        this.logger.error(s);
    }

    public void summaryAddedSuccessfully(String s) {
        this.logger.info(s);
    }
}
