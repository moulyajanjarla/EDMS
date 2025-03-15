package com.edms.lite.service;

import com.edms.lite.model.Document;
import com.edms.lite.model.DocumentVersion;
import com.edms.lite.repository.DocumentRepository;
import com.edms.lite.repository.DocumentVersionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("hiding")
@Service
public class DocumentService<versionRepository> {

    @Autowired private DocumentRepository documentRepository;
    @Autowired private DocumentVersionRepository versionRepository;

    public Document saveDocument(MultipartFile file, String title, String desc, List<String> tags) throws IOException {
        // Save file
        String uploadPath = "uploads/" + file.getOriginalFilename();
        file.transferTo(new File(uploadPath));

        Document doc = new Document();
        doc.setTitle(title);
        doc.setDescription(desc);
        doc.setFilePath(uploadPath);
        doc.setCurrentVersion(1);
        doc.setTitle(tags);

        Document saved = documentRepository.save(doc);

        DocumentVersion version = new DocumentVersion();
        version.setDocumentId(saved.getId());
        version.setVersionNumber(1);
        version.setFilePath(uploadPath);
        com.edms.lite.service.versionRepository.save(version);

        return saved;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> searchDocuments(String keyword) {
        return documentRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
    public List<DocumentVersion> getDocumentVersions(Long docId) {
    return versionRepository.findByDocumentId(docId);
}

}
