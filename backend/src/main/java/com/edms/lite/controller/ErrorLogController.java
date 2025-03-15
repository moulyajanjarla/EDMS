package com.edms.lite.controller;

import com.edms.lite.model.ErrorLog;
import com.edms.lite.service.ErrorLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/errors")
public class ErrorLogController {

    @Autowired private ErrorLogRepository repo;

    @PostMapping
    public ResponseEntity<ErrorLog> logError(@RequestBody ErrorLog log) {
        return ResponseEntity.ok(repo.save(log));
    }

    @GetMapping
    public List<ErrorLog> getAllLogs() {
        return repo.findAll();
    }
}
