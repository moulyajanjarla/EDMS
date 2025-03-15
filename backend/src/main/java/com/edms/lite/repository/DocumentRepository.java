package com.edms.lite.repository;

import com.edms.lite.model.Document;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByTitleContainingIgnoreCase(String keyword);
}

