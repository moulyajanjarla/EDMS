package com.edms.lite.repository;

import java.util.List;

import com.edms.lite.model.DocumentVersion;

public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long> {
    List<DocumentVersion> findByDocumentId(Long docId);
}

