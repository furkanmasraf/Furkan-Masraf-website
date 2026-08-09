package com.furkanmasraf.portfolio.controller;

import com.furkanmasraf.portfolio.dto.ApiResponse;
import com.furkanmasraf.portfolio.model.*;
import com.furkanmasraf.portfolio.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PortfolioController {

    private final ProfileInfoRepository profileInfoRepository;
    private final ExperienceRepository experienceRepository;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final CertificateRepository certificateRepository;

    @GetMapping("/profile")
    public ApiResponse<ProfileInfo> getProfile() {
        ProfileInfo profile = profileInfoRepository.findAll().stream()
                .findFirst()
                .orElse(null);
        return ApiResponse.success("Profil bilgileri başarıyla getirildi", profile);
    }

    @GetMapping("/experiences")
    public ApiResponse<List<Experience>> getExperiences() {
        List<Experience> experiences = experienceRepository.findAllByOrderByDisplayOrderAsc();
        return ApiResponse.success("Deneyimler başarıyla getirildi", experiences);
    }

    @GetMapping("/projects")
    public ApiResponse<List<Project>> getProjects(@RequestParam(required = false) String category) {
        List<Project> projects;
        if (category != null && !category.isBlank()) {
            projects = projectRepository.findByCategory(category);
        } else {
            projects = projectRepository.findAllByOrderByDisplayOrderAsc();
        }
        return ApiResponse.success("Projeler başarıyla getirildi", projects);
    }

    @GetMapping("/skills")
    public ApiResponse<List<Skill>> getSkills(@RequestParam(required = false) String category) {
        List<Skill> skills;
        if (category != null && !category.isBlank()) {
            skills = skillRepository.findByCategory(category);
        } else {
            skills = skillRepository.findAll();
        }
        return ApiResponse.success("Yetenekler başarıyla getirildi", skills);
    }

    @GetMapping("/certificates")
    public ApiResponse<List<Certificate>> getCertificates() {
        List<Certificate> certificates = certificateRepository.findAll();
        return ApiResponse.success("Sertifikalar başarıyla getirildi", certificates);
    }
}
