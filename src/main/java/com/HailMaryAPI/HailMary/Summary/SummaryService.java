package com.HailMaryAPI.HailMary.Summary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.HailMaryAPI.HailMary.Logging.LoggingController;

@Service
public class SummaryService {
    private final SummaryRepository summaryRepository;
    private final LoggingController logs;

    @Autowired
    public SummaryService(SummaryRepository summaryRepository, LoggingController logs) {
        this.summaryRepository = summaryRepository;
        this.logs = logs;
    }

    public Summary getSummaryById(int id) {
        boolean exists = summaryRepository.existsById(id);
        if(!exists) {
            logs.summaryDoesntExist("Summary with id: " + id + " doesnt exsist");
            return null;
        }
        else{
            logs.summaryRetrievedSuccessfully("Summary " + id + " was retrieved");
            return summaryRepository.getOne(id);
        }
    }

    public void addNewsummary(Summary summary) {
        Optional<Summary> summaryOptional = summaryRepository.findSummary(summary.getSummary_id());
        if(summaryOptional.isPresent()) {
            logs.summaryDoesExist("Summary " + summary.getSummary_id() + " already exsists");
        }
        summaryRepository.save(summary);
        logs.summaryAddedSuccessfully("Successfully created new summary with id: " + summary.getSummary_id());
    }
}