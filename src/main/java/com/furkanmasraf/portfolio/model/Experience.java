package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String period;
    private String location;
    private int displayOrder;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "experience_highlights", joinColumns = @JoinColumn(name = "experience_id"))
    @Column(length = 1000)
    private List<String> highlights;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "experience_technologies", joinColumns = @JoinColumn(name = "experience_id"))
    private List<String> technologies;

    public Experience() {}

    public Experience(Long id, String company, String role, String period, String location, int displayOrder, List<String> highlights, List<String> technologies) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.period = period;
        this.location = location;
        this.displayOrder = displayOrder;
        this.highlights = highlights;
        this.technologies = technologies;
    }

    public static ExperienceBuilder builder() {
        return new ExperienceBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
    public List<String> getHighlights() { return highlights; }
    public void setHighlights(List<String> highlights) { this.highlights = highlights; }
    public List<String> getTechnologies() { return technologies; }
    public void setTechnologies(List<String> technologies) { this.technologies = technologies; }

    public static class ExperienceBuilder {
        private Long id;
        private String company;
        private String role;
        private String period;
        private String location;
        private int displayOrder;
        private List<String> highlights;
        private List<String> technologies;

        public ExperienceBuilder id(Long id) { this.id = id; return this; }
        public ExperienceBuilder company(String company) { this.company = company; return this; }
        public ExperienceBuilder role(String role) { this.role = role; return this; }
        public ExperienceBuilder period(String period) { this.period = period; return this; }
        public ExperienceBuilder location(String location) { this.location = location; return this; }
        public ExperienceBuilder displayOrder(int displayOrder) { this.displayOrder = displayOrder; return this; }
        public ExperienceBuilder highlights(List<String> highlights) { this.highlights = highlights; return this; }
        public ExperienceBuilder technologies(List<String> technologies) { this.technologies = technologies; return this; }

        public Experience build() {
            return new Experience(id, company, role, period, location, displayOrder, highlights, technologies);
        }
    }
}
