package com.edms.lite.service;

import com.edms.lite.model.Document;
import com.edms.lite.model.ErrorLog;
import com.edms.lite.repository.DocumentRepository;
import com.edms.lite.repository.ErrorLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;
    private final DocumentRepository documentRepository;

    public ErrorLogService(ErrorLogRepository errorLogRepository, DocumentRepository documentRepository) {
        this.errorLogRepository = errorLogRepository;
        this.documentRepository = documentRepository;
    }

    public ErrorLog logError(ErrorLog errorLog, Long documentId) {
        if (documentId != null) {
            Optional<Document> document = documentRepository.findById(documentId);
            document.ifPresent(errorLog::setDocument);  // Set document if it exists
        }
        return errorLogRepository.save(errorLog);
    }

    public List<ErrorLog> getAllErrors() {
        return errorLogRepository.findAll();
    }
}
