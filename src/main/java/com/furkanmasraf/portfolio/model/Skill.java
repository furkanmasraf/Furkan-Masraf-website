package com.furkanmasraf.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int proficiencyPercentage;
    private String iconName;
    private String highlightText;

    public Skill() {}

    public Skill(Long id, String name, String category, int proficiencyPercentage, String iconName, String highlightText) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.proficiencyPercentage = proficiencyPercentage;
        this.iconName = iconName;
        this.highlightText = highlightText;
    }

    public static SkillBuilder builder() {
        return new SkillBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getProficiencyPercentage() { return proficiencyPercentage; }
    public void setProficiencyPercentage(int proficiencyPercentage) { this.proficiencyPercentage = proficiencyPercentage; }
    public String getIconName() { return iconName; }
    public void setIconName(String iconName) { this.iconName = iconName; }
    public String getHighlightText() { return highlightText; }
    public void setHighlightText(String highlightText) { this.highlightText = highlightText; }

    public static class SkillBuilder {
        private Long id;
        private String name;
        private String category;
        private int proficiencyPercentage;
        private String iconName;
        private String highlightText;

        public SkillBuilder id(Long id) { this.id = id; return this; }
        public SkillBuilder name(String name) { this.name = name; return this; }
        public SkillBuilder category(String category) { this.category = category; return this; }
        public SkillBuilder proficiencyPercentage(int proficiencyPercentage) { this.proficiencyPercentage = proficiencyPercentage; return this; }
        public SkillBuilder iconName(String iconName) { this.iconName = iconName; return this; }
        public SkillBuilder highlightText(String highlightText) { this.highlightText = highlightText; return this; }

        public Skill build() {
            return new Skill(id, name, category, proficiencyPercentage, iconName, highlightText);
        }
    }
}
