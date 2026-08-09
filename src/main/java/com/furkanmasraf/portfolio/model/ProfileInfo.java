package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profile_info")
public class ProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String location;
    private String linkedinUrl;
    private String githubUrl;

    @Column(length = 2000)
    private String bio;

    private String educationSummary;
    private String university;
    private String department;
    private String graduationYear;

    public ProfileInfo() {}

    public ProfileInfo(Long id, String fullName, String title, String email, String phone, String location, String linkedinUrl, String githubUrl, String bio, String educationSummary, String university, String department, String graduationYear) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.bio = bio;
        this.educationSummary = educationSummary;
        this.university = university;
        this.department = department;
        this.graduationYear = graduationYear;
    }

    public static ProfileInfoBuilder builder() {
        return new ProfileInfoBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }
    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getEducationSummary() { return educationSummary; }
    public void setEducationSummary(String educationSummary) { this.educationSummary = educationSummary; }
    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getGraduationYear() { return graduationYear; }
    public void setGraduationYear(String graduationYear) { this.graduationYear = graduationYear; }

    public static class ProfileInfoBuilder {
        private Long id;
        private String fullName;
        private String title;
        private String email;
        private String phone;
        private String location;
        private String linkedinUrl;
        private String githubUrl;
        private String bio;
        private String educationSummary;
        private String university;
        private String department;
        private String graduationYear;

        public ProfileInfoBuilder id(Long id) { this.id = id; return this; }
        public ProfileInfoBuilder fullName(String fullName) { this.fullName = fullName; return this; }
        public ProfileInfoBuilder title(String title) { this.title = title; return this; }
        public ProfileInfoBuilder email(String email) { this.email = email; return this; }
        public ProfileInfoBuilder phone(String phone) { this.phone = phone; return this; }
        public ProfileInfoBuilder location(String location) { this.location = location; return this; }
        public ProfileInfoBuilder linkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; return this; }
        public ProfileInfoBuilder githubUrl(String githubUrl) { this.githubUrl = githubUrl; return this; }
        public ProfileInfoBuilder bio(String bio) { this.bio = bio; return this; }
        public ProfileInfoBuilder educationSummary(String educationSummary) { this.educationSummary = educationSummary; return this; }
        public ProfileInfoBuilder university(String university) { this.university = university; return this; }
        public ProfileInfoBuilder department(String department) { this.department = department; return this; }
        public ProfileInfoBuilder graduationYear(String graduationYear) { this.graduationYear = graduationYear; return this; }

        public ProfileInfo build() {
            return new ProfileInfo(id, fullName, title, email, phone, location, linkedinUrl, githubUrl, bio, educationSummary, university, department, graduationYear);
        }
    }
}
