package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // "Backend", "Frontend", "Database", "DevOps & Tools", "Languages", "Methodologies"
    private int proficiencyPercentage; // e.g. 95, 90, 85
    private String iconName;
    private String highlightText;
}
