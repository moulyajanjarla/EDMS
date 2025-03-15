package com.edms.lite.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_versions")
public class DocumentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long documentId;
    private Integer versionNumber;
    private String filePath;
    private LocalDateTime uploadedAt = LocalDateTime.now();
    public void setVersionNumber(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVersionNumber'");
    }
    public void setFilePath(String uploadPath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFilePath'");
    }
    public void setDocumentId(Object id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDocumentId'");
    }

    // Getters and setters
}

