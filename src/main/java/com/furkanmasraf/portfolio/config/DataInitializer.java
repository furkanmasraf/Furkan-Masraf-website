package com.furkanmasraf.portfolio.config;

import com.furkanmasraf.portfolio.model.*;
import com.furkanmasraf.portfolio.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProfileInfoRepository profileInfoRepository;
    private final ExperienceRepository experienceRepository;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final CertificateRepository certificateRepository;

    @Override
    public void run(String... args) throws Exception {
        if (profileInfoRepository.count() == 0) {
            initProfile();
            initExperiences();
            initProjects();
            initSkills();
            initCertificates();
        }
    }

    private void initProfile() {
        ProfileInfo profile = ProfileInfo.builder()
                .fullName("Furkan Masraf")
                .title("Backend Developer")
                .email("masraffurkan@gmail.com")
                .phone("+90 538 472 75 54")
                .location("İstanbul, Türkiye")
                .linkedinUrl("https://linkedin.com/in/furkanmasraf")
                .githubUrl("https://github.com/furkanmasraf")
                .bio("Java ve Spring Boot ekosisteminde ölçeklenebilir backend sistemleri, mikroservis mimarileri ve yüksek erişilebilirlikli RESTful API'ler geliştiren Bilgisayar Mühendisi. Clean Code ilkeleri, Aspect-Oriented Programming (AOP), Redis caching, Resilience4j Retry mekanizmaları ve tip güvenli hata yönetimi konularında tutkulu mühendislik yaklaşımına sahibim.")
                .university("Üsküdar Üniversitesi")
                .department("Bilgisayar Mühendisliği")
                .graduationYear("2020 – 2026")
                .build();

        profileInfoRepository.save(profile);
    }

    private void initExperiences() {
        Experience dogus = Experience.builder()
                .company("Doğuş Teknoloji")
                .role("Backend Developer Intern")
                .period("05/2026 – 06/2026")
                .location("İstanbul")
                .displayOrder(1)
                .highlights(Arrays.asList(
                        "Servisler arası entegrasyonların güvenilirliğini artırmak amacıyla, uzak sunucu kesintilerine karşı Retry mekanizması geliştirme; başarısız isteklerin belirli periyotlarla otomatik olarak tekrarlanmasını sağlayarak sistemin hata toleransını (Fault Tolerance) güçlendirme üzerine çalışmalar yaptım.",
                        "Proje içindeki hata ve bilgilendirme mesajlarını tip güvenliği (Type Safety) prensiplerine uygun olarak merkezi bir yapıda yönetmek amacıyla ilgili Enum sınıflarının tasarımını ve entegrasyonunu üzerinde çalışmalar yürüttüm.",
                        "Kurumsal mikroservis mimarilerini ve harici sistem entegrasyon süreçlerini analiz ederek büyük ölçekli projelerin kod tabanına (codebase) adaptasyon sağladım."
                ))
                .technologies(Arrays.asList("Java", "Spring Boot", "Resilience4j", "Microservices", "Clean Code", "Fault Tolerance"))
                .build();

        Experience fiba = Experience.builder()
                .company("Fibabanka")
                .role("Backend Developer Intern")
                .period("03/2025 – 08/2025")
                .location("İstanbul")
                .displayOrder(2)
                .highlights(Arrays.asList(
                        "Java ve Spring Boot kurumsal projelerinde Clean Code prensipleri doğrultusunda kod refaktörü süreçlerine katıldım; string literallerini static yapılara taşıyarak bellek yönetimini optimize ettim.",
                        "Aspect-Oriented Programming (AOP) mimarisini inceleyerek, iş mantığı katmanını etkilemeden çalışan merkezi ve modüler loglama yapıları üzerinde çalışmalar yürüttüm.",
                        "Uygulama kararlılığını artırmak amacıyla runtime hatalarını ve özellikle NullPointerException (NPE) vakalarını analiz edip kalıcı çözümler üreterek hata ayıklama (debugging) süreçlerinde rol aldım.",
                        "Yeni geliştirilecek servisler için API iskelet tasarımlarını (endpoint stubs) oluşturarak entegrasyon süreçlerinin hızlandırılmasına katkı sağladım.",
                        "Agile/Scrum metodolojisiyle çalışan bir bankacılık ekibinde, sprint planlama ve günlük (Daily Stand-up) toplantılarına aktif katılım sağladım."
                ))
                .technologies(Arrays.asList("Java", "Spring Boot", "AOP", "Clean Code", "Debugging", "Agile/Scrum", "API Stubs"))
                .build();

        Experience bilyoner = Experience.builder()
                .company("Bilyoner")
                .role("iOS Mobile Developer Intern")
                .period("06/2024 – 07/2024")
                .location("İstanbul")
                .displayOrder(3)
                .highlights(Arrays.asList(
                        "Swift kullanarak iOS uygulama geliştirme süreçlerinde görev aldım.",
                        "API entegrasyonları ve kullanıcı arayüzü iyileştirmeleri yaptım.",
                        "Takım içi kod inceleme (code review) süreçlerine katıldım."
                ))
                .technologies(Arrays.asList("Swift", "iOS", "REST API", "Code Review", "UI Optimization"))
                .build();

        experienceRepository.saveAll(Arrays.asList(dogus, fiba, bilyoner));
    }

    private void initProjects() {
        Project hairdresser = Project.builder()
                .title("Hairdresser Appointment & Management System")
                .category("Spring Boot / Backend")
                .description("Customer ve Shop Admin rol tabanlı yetkilendirme altyapısına sahip kurumsal düzeyde berber/kuaför randevu ve dükkan yönetim sistemi backend mimarisi.")
                .backendGithubUrl("https://github.com/furkanmasraf")
                .frontendGithubUrl("https://github.com/furkanmasraf")
                .featured(true)
                .displayOrder(1)
                .keyFeatures(Arrays.asList(
                        "Java 17, Spring Boot, Spring Security ve JWT mimarisi ile rol tabanlı yetkilendirme (Customer, Shop Admin).",
                        "Asenkron veritabanı sorguları üzerinden dinamik çakışma kontrolleri ile randevu çakışmalarının engellenmesi.",
                        "Redis Caching mekanizması ile dükkan ve hizmet listeleme yanıt sürelerinin optimize edilmesi ve DB yükünün azaltılması.",
                        "JUnit 5 ve Mockito ile %80+ kapsayıcılıkta birim testler.",
                        "Resilience4j ile dış servis ağ kesintilerine karşı Retry (Yeniden Deneme) şablonu.",
                        "Docker Compose ile PostgreSQL, Redis ve mesaj kuyruğu servislerinin tek komutla ayağa kaldırılması.",
                        "@ControllerAdvice ile Global Exception Handling ve standart JSON hata cevabı yönetimi."
                ))
                .technologies(Arrays.asList("Java 17", "Spring Boot", "Spring Security", "JWT", "Redis", "PostgreSQL", "Resilience4j", "Docker", "JUnit 5", "Mockito"))
                .build();

        Project finance = Project.builder()
                .title("Personal Finance Tracking Application")
                .category("C# / .NET Core")
                .description("Ekip çalışması ile geliştirilen, kullanıcıların gelir-gider takibini yapabildiği, kategori bazlı harcama analizi çıkardığı ölçeklenebilir backend sistemi.")
                .backendGithubUrl("https://github.com/furkanmasraf")
                .featured(true)
                .displayOrder(2)
                .keyFeatures(Arrays.asList(
                        "C# ve .NET Core altyapısı ile katmanlı ve ölçeklenebilir RESTful API mimarisi.",
                        "Kullanıcı gelir-gider takibi, kategori analizi ve ayrıntılı raporlama servisleri.",
                        "Gerçek kullanıcı ihtiyaçlarına göre iş mantığı (business logic) kurallarının tasarlanması."
                ))
                .technologies(Arrays.asList("C#", ".NET Core", "RESTful API", "LINQ", "SQL Server", "Architecture"))
                .build();

        Project cafe = Project.builder()
                .title("Cafe & Restaurant Database Management System")
                .category("Full-Stack & DB")
                .description("Kullanıcı, ürün ve sipariş yönetimi sağlayan veritabanı ve oturum yönetimi mimarisi.")
                .backendGithubUrl("https://github.com/furkanmasraf")
                .featured(false)
                .displayOrder(3)
                .keyFeatures(Arrays.asList(
                        "Kullanıcı, ürün ve sipariş yönetimi için normalize edilmiş veritabanı mimarisi.",
                        "Gelişmiş filtreleme, arama ve güvenli oturum yönetimi (session management).",
                        "Frontend ve backend katmanları arasında kesintisiz entegrasyon."
                ))
                .technologies(Arrays.asList("Java", "PostgreSQL", "Session Management", "REST API", "JavaScript"))
                .build();

        projectRepository.saveAll(Arrays.asList(hairdresser, finance, cafe));
    }

    private void initSkills() {
        List<Skill> skills = Arrays.asList(
                // Backend & Languages
                Skill.builder().name("Java").category("Backend").proficiencyPercentage(95).iconName("code").highlightText("Clean Code, Java 17/21").build(),
                Skill.builder().name("Spring Boot").category("Backend").proficiencyPercentage(95).iconName("server").highlightText("REST API, Security, Data JPA").build(),
                Skill.builder().name("Spring Data JPA / Hibernate").category("Backend").proficiencyPercentage(90).iconName("database").highlightText("ORM Optimization, JPQL").build(),
                Skill.builder().name("Spring Security & JWT").category("Backend").proficiencyPercentage(88).iconName("lock").highlightText("RBAC Auth, Token Management").build(),
                Skill.builder().name("C# / .NET").category("Backend").proficiencyPercentage(80).iconName("terminal").highlightText("Clean Architecture, Linq").build(),
                
                // Advanced Backend & Resilience
                Skill.builder().name("Redis Caching").category("Backend").proficiencyPercentage(85).iconName("zap").highlightText("In-Memory Caching & Performance").build(),
                Skill.builder().name("Resilience4j & Retry").category("Backend").proficiencyPercentage(85).iconName("shield").highlightText("Fault Tolerance, Circuit Breaker").build(),
                Skill.builder().name("Aspect-Oriented Programming (AOP)").category("Backend").proficiencyPercentage(88).iconName("layers").highlightText("Cross-cutting Concerns & Logging").build(),
                
                // Database & DevOps
                Skill.builder().name("PostgreSQL").category("Database").proficiencyPercentage(90).iconName("database").highlightText("Relational Schema & Performance").build(),
                Skill.builder().name("Microsoft SQL Server").category("Database").proficiencyPercentage(82).iconName("database").highlightText("T-SQL & Stored Procedures").build(),
                Skill.builder().name("Docker & Docker Compose").category("DevOps").proficiencyPercentage(85).iconName("box").highlightText("Containerization & Orchestration").build(),
                Skill.builder().name("Git / GitHub / Azure DevOps").category("DevOps").proficiencyPercentage(90).iconName("git-branch").highlightText("Version Control & CI/CD").build(),

                // Testing & Mobile & Web
                Skill.builder().name("JUnit 5 & Mockito").category("Testing").proficiencyPercentage(85).iconName("check-circle").highlightText("Unit Testing & Mocking").build(),
                Skill.builder().name("React & TypeScript").category("Frontend").proficiencyPercentage(80).iconName("layout").highlightText("Modern UI, Component State").build(),
                Skill.builder().name("Swift (iOS)").category("Mobile").proficiencyPercentage(75).iconName("smartphone").highlightText("iOS Development & API integration").build()
        );

        skillRepository.saveAll(skills);
    }

    private void initCertificates() {
        List<Certificate> certs = Arrays.asList(
                Certificate.builder()
                        .title("Data Science")
                        .issuer("Coderspace")
                        .issueYear("2025")
                        .description("Veri analizi, model değerlendirme ve istatistiksel yaklaşım becerileri.")
                        .badgeCategory("Data Science")
                        .build(),
                Certificate.builder()
                        .title("Java & Spring Boot")
                        .issuer("BTK Akademi")
                        .issueYear("2025")
                        .description("Kurumsal backend mimarisi, REST API geliştirme ve Spring ekosistemi derinlemesine eğitimi.")
                        .badgeCategory("Backend")
                        .build(),
                Certificate.builder()
                        .title("Fibabanka Future Talent Programme")
                        .issuer("Fibabanka")
                        .issueYear("2025")
                        .description("Bankacılık yazılım sistemleri, Agile/Scrum metodolojisi ve kurumsal kod geliştirme pratikleri.")
                        .badgeCategory("Enterprise")
                        .build(),
                Certificate.builder()
                        .title("Java – Geleceği Yazanlar")
                        .issuer("Turkcell")
                        .issueYear("2025")
                        .description("Nesne yönelimli programlama (OOP) ve ileri düzey Java mimarileri.")
                        .badgeCategory("Java")
                        .build(),
                Certificate.builder()
                        .title("Foundational C#")
                        .issuer("Microsoft / FreeCodeCamp")
                        .issueYear("2024")
                        .description(".NET yazılım temelleri, nesne yönelimli tasarım ve C# dili yetkinliği.")
                        .badgeCategory(".NET")
                        .build()
        );

        certificateRepository.saveAll(certs);
    }
}
