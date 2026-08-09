package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
