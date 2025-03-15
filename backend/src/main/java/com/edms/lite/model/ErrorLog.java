package com.edms.lite.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "error_logs")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorType;
    private String severity;
    private String message;
    private String rootCauseAnalysis;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
