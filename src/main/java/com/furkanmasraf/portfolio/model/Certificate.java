package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String issuer;
    private String issueYear;
    private String description;
    private String badgeCategory;

    public Certificate() {}

    public Certificate(Long id, String title, String issuer, String issueYear, String description, String badgeCategory) {
        this.id = id;
        this.title = title;
        this.issuer = issuer;
        this.issueYear = issueYear;
        this.description = description;
        this.badgeCategory = badgeCategory;
    }

    public static CertificateBuilder builder() {
        return new CertificateBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public String getIssueYear() { return issueYear; }
    public void setIssueYear(String issueYear) { this.issueYear = issueYear; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getBadgeCategory() { return badgeCategory; }
    public void setBadgeCategory(String badgeCategory) { this.badgeCategory = badgeCategory; }

    public static class CertificateBuilder {
        private Long id;
        private String title;
        private String issuer;
        private String issueYear;
        private String description;
        private String badgeCategory;

        public CertificateBuilder id(Long id) { this.id = id; return this; }
        public CertificateBuilder title(String title) { this.title = title; return this; }
        public CertificateBuilder issuer(String issuer) { this.issuer = issuer; return this; }
        public CertificateBuilder issueYear(String issueYear) { this.issueYear = issueYear; return this; }
        public CertificateBuilder description(String description) { this.description = description; return this; }
        public CertificateBuilder badgeCategory(String badgeCategory) { this.badgeCategory = badgeCategory; return this; }

        public Certificate build() {
            return new Certificate(id, title, issuer, issueYear, description, badgeCategory);
        }
    }
}
