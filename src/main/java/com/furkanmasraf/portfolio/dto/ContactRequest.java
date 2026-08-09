package com.furkanmasraf.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactRequest {

    @NotBlank(message = "İsim alanı boş bırakılamaz")
    @Size(min = 2, max = 100, message = "İsim 2 ile 100 karakter arasında olmalıdır")
    private String name;

    @NotBlank(message = "E-posta adresi boş bırakılamaz")
    @Email(message = "Geçerli bir e-posta adresi giriniz")
    private String email;

    @NotBlank(message = "Konu başlığı boş bırakılamaz")
    private String subject;

    @NotBlank(message = "Mesaj içeriği boş bırakılamaz")
    @Size(min = 10, max = 2000, message = "Mesaj en az 10 karakter olmalıdır")
    private String message;

    public ContactRequest() {}

    public ContactRequest(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
