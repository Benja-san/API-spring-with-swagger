package SkillsLab.demo.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SkillsLab.demo.API.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    public Optional<Category> findBySlug(String slug);
}
