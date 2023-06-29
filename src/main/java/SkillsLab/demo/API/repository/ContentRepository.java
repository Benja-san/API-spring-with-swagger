package SkillsLab.demo.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SkillsLab.demo.API.entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    public Optional<Content> findBySlug(String slug);
}
