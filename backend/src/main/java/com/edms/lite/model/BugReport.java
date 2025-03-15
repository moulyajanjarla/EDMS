package com.edms.lite.model;
@Entity
@Table(name = "bug_reports")
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorType;
    private String severity;
    private String message;
    private String rootCause;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}

