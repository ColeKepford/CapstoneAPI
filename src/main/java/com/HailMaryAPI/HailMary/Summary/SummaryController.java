package com.HailMaryAPI.HailMary.Summary;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/summary")
@CrossOrigin(origins="http://localhost:3000")
public class SummaryController {
    private final SummaryService summaryService;

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/id/{id}")
    public Summary getsummary(@PathVariable("id")Integer id) {
        return summaryService.getSummaryById(id);
    }

    @PostMapping(path="/RegisterSummary", consumes = "application/json", produces = "application/json")
    public void addNewsummary(@RequestBody Summary summary) {
        summaryService.addNewsummary(summary);
    }
}
