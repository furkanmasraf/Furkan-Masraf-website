package com.furkanmasraf.portfolio.controller;

import com.furkanmasraf.portfolio.dto.ApiResponse;
import com.furkanmasraf.portfolio.dto.ContactRequest;
import com.furkanmasraf.portfolio.model.ContactMessage;
import com.furkanmasraf.portfolio.repository.ContactMessageRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    public ContactController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @PostMapping("/messages")
    public ApiResponse<ContactMessage> sendMessage(@Valid @RequestBody ContactRequest request) {
        ContactMessage message = ContactMessage.builder()
                .senderName(request.getName())
                .senderEmail(request.getEmail())
                .subject(request.getSubject())
                .message(request.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        ContactMessage savedMessage = contactMessageRepository.save(message);

        return ApiResponse.success(
                "Mesajınız başarıyla Furkan Masraf'a iletildi. En kısa sürede dönüş sağlanacaktır!",
                savedMessage
        );
    }
}
