package com.edms.lite.service;
@Service
public class BugReportService {

    @Autowired
    private BugReportRepository bugReportRepo;

    public BugReport saveBugReport(BugReport bugReport) {
        return bugReportRepo.save(bugReport);
    }

    public List<BugReport> getAllReports() {
        return bugReportRepo.findAll();
    }
}

