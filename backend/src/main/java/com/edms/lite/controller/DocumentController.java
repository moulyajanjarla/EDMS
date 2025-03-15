package com.edms.lite.controller;

import com.edms.lite.model.Document;
import com.edms.lite.model.DocumentVersion;
import com.edms.lite.repository.DocumentRepository;
import com.edms.lite.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:3000")
public class DocumentController {

    @Autowired private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDoc(@RequestParam("file") MultipartFile file,
                                       @RequestParam("title") String title,
                                       @RequestParam("description") String desc,
                                       @RequestParam("tags") List<String> tags) {
        try {
            Document doc = documentService.saveDocument(file, title, desc, tags);
            return ResponseEntity.ok(doc);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload Failed");
        }
    }

    @GetMapping
    public List<Document> listDocs() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/search")
    public List<Document> search(@RequestParam("keyword") String keyword) {
        return documentService.searchDocuments(keyword);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Deleted");
    }
    @GetMapping("/{id}/versions")
public ResponseEntity<List<DocumentVersion>> getVersionHistory(@PathVariable Long id) {
    List<DocumentVersion> versions = documentService.getDocumentVersions(id);
    return ResponseEntity.ok(versions);
}
}
