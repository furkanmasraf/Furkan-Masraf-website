package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;

    @Column(length = 1500)
    private String description;

    private String backendGithubUrl;
    private String frontendGithubUrl;
    private boolean featured;
    private int displayOrder;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_features", joinColumns = @JoinColumn(name = "project_id"))
    @Column(length = 1000)
    private List<String> keyFeatures;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_technologies", joinColumns = @JoinColumn(name = "project_id"))
    private List<String> technologies;

    public Project() {}

    public Project(Long id, String title, String category, String description, String backendGithubUrl, String frontendGithubUrl, boolean featured, int displayOrder, List<String> keyFeatures, List<String> technologies) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.backendGithubUrl = backendGithubUrl;
        this.frontendGithubUrl = frontendGithubUrl;
        this.featured = featured;
        this.displayOrder = displayOrder;
        this.keyFeatures = keyFeatures;
        this.technologies = technologies;
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getBackendGithubUrl() { return backendGithubUrl; }
    public void setBackendGithubUrl(String backendGithubUrl) { this.backendGithubUrl = backendGithubUrl; }
    public String getFrontendGithubUrl() { return frontendGithubUrl; }
    public void setFrontendGithubUrl(String frontendGithubUrl) { this.frontendGithubUrl = frontendGithubUrl; }
    public boolean isFeatured() { return featured; }
    public void setFeatured(boolean featured) { this.featured = featured; }
    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
    public List<String> getKeyFeatures() { return keyFeatures; }
    public void setKeyFeatures(List<String> keyFeatures) { this.keyFeatures = keyFeatures; }
    public List<String> getTechnologies() { return technologies; }
    public void setTechnologies(List<String> technologies) { this.technologies = technologies; }

    public static class ProjectBuilder {
        private Long id;
        private String title;
        private String category;
        private String description;
        private String backendGithubUrl;
        private String frontendGithubUrl;
        private boolean featured;
        private int displayOrder;
        private List<String> keyFeatures;
        private List<String> technologies;

        public ProjectBuilder id(Long id) { this.id = id; return this; }
        public ProjectBuilder title(String title) { this.title = title; return this; }
        public ProjectBuilder category(String category) { this.category = category; return this; }
        public ProjectBuilder description(String description) { this.description = description; return this; }
        public ProjectBuilder backendGithubUrl(String backendGithubUrl) { this.backendGithubUrl = backendGithubUrl; return this; }
        public ProjectBuilder frontendGithubUrl(String frontendGithubUrl) { this.frontendGithubUrl = frontendGithubUrl; return this; }
        public ProjectBuilder featured(boolean featured) { this.featured = featured; return this; }
        public ProjectBuilder displayOrder(int displayOrder) { this.displayOrder = displayOrder; return this; }
        public ProjectBuilder keyFeatures(List<String> keyFeatures) { this.keyFeatures = keyFeatures; return this; }
        public ProjectBuilder technologies(List<String> technologies) { this.technologies = technologies; return this; }

        public Project build() {
            return new Project(id, title, category, description, backendGithubUrl, frontendGithubUrl, featured, displayOrder, keyFeatures, technologies);
        }
    }
}
