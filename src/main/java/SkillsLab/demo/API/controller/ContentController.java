package SkillsLab.demo.API.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import SkillsLab.demo.API.repository.CategoryRepository;
import SkillsLab.demo.API.repository.ContentRepository;
import SkillsLab.demo.API.entity.Content;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:4200")
public class ContentController {
    
    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;

    ContentController(ContentRepository contentRepository, CategoryRepository categoryRepository) {
        this.contentRepository = contentRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    // @GetMapping("/{id}")
    // public Content getContent(@PathVariable Long id) {
    //     return contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    // }

    @GetMapping("/{slug}")
    public Content getContent(@PathVariable String slug) {
        return contentRepository.findBySlug(slug).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @PostMapping("/add")
    public Content addContent() {
        Content content = new Content("Pôle Nord Design", "Pôle Nord Design, architecte d'interieur vous accompagne dans tous vos projets de rénovations sur les Hauts de France", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque in auctor risus, non fringilla lorem. Suspendisse aliquet ante dui, at cursus nulla elementum et. Donec vitae eleifend urna. Morbi laoreet, sem at feugiat luctus, eros ante pellentesque elit, a rutrum libero mauris eu turpis. Suspendisse maximus erat convallis erat laoreet, eget porttitor nulla interdum. Morbi nec tempus diam. Donec tincidunt et dui quis posuere. Nunc semper odio at ipsum interdum semper. Suspendisse at nisl in nisi dictum ornare. Etiam finibus id velit nec fringilla. Ut tortor felis, auctor id lacus nec, accumsan semper ex. Nulla facilisi. Ut id arcu vitae lorem bibendum vulputate. Nunc tristique ex sit amet efficitur efficitur. Vestibulum quis rhoncus metus, et faucibus lacus. Nullam vel lorem urna. Donec faucibus ut tortor vitae dignissim. Fusce nec massa ante. Aliquam tincidunt leo vitae lacinia pharetra. Suspendisse malesuada placerat sagittis. Vestibulum ornare mi sit amet dolor vehicula, eu convallis metus placerat. Nulla malesuada ex in ligula vehicula, eget sodales tellus aliquet. Curabitur placerat porttitor dapibus. Aenean dictum pellentesque mi nec euismod. Curabitur maximus aliquam dignissim. Nam tincidunt urna sit amet sem ultrices, nec venenatis risus dictum.");
        content.setCategory(categoryRepository.findById(1L).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")));
        content.setSlug("pole-nord-design");
        content.setCreateTime(java.time.LocalDateTime.now());
        content.setUpdateTime(java.time.LocalDateTime.now());
        return contentRepository.save(content);
    }

    @PutMapping("/update")
    public Content updateContent() {
        Content contentToUpdate = contentRepository.findById(1L).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
        contentToUpdate.setContent("Content updated !");
        return contentRepository.save(contentToUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteContent() {
        contentRepository.deleteById(5L);
    }

}
