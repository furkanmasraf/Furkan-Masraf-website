package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderName;
    private String senderEmail;
    private String subject;

    @Column(length = 2000)
    private String message;

    private LocalDateTime createdAt;

    public ContactMessage() {}

    public ContactMessage(Long id, String senderName, String senderEmail, String subject, String message, LocalDateTime createdAt) {
        this.id = id;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.message = message;
        this.createdAt = createdAt;
    }

    public static ContactMessageBuilder builder() {
        return new ContactMessageBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public String getSenderEmail() { return senderEmail; }
    public void setSenderEmail(String senderEmail) { this.senderEmail = senderEmail; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class ContactMessageBuilder {
        private Long id;
        private String senderName;
        private String senderEmail;
        private String subject;
        private String message;
        private LocalDateTime createdAt;

        public ContactMessageBuilder id(Long id) { this.id = id; return this; }
        public ContactMessageBuilder senderName(String senderName) { this.senderName = senderName; return this; }
        public ContactMessageBuilder senderEmail(String senderEmail) { this.senderEmail = senderEmail; return this; }
        public ContactMessageBuilder subject(String subject) { this.subject = subject; return this; }
        public ContactMessageBuilder message(String message) { this.message = message; return this; }
        public ContactMessageBuilder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }

        public ContactMessage build() {
            return new ContactMessage(id, senderName, senderEmail, subject, message, createdAt);
        }
    }
}
