package com.edms.lite.controller;
@RestController
@RequestMapping("/api/bugs")
public class BugReportController {

    @Autowired
    private BugReportService bugReportService;

    @PostMapping
    public ResponseEntity<BugReport> createBugReport(@RequestBody BugReport bugReport) {
        return ResponseEntity.ok(bugReportService.saveBugReport(bugReport));
    }

    @GetMapping
    public ResponseEntity<List<BugReport>> getAllReports() {
        return ResponseEntity.ok(bugReportService.getAllReports());
    }
}

