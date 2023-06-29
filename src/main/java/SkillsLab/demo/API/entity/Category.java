package SkillsLab.demo.API.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String slug;
    @OneToMany(mappedBy = "category")
    private Set<Content> contents;
    @NotBlank
    private String description;

    public Category() {
    }

    public Category(
        String name,
        String description
    ) {
        this.name = name;
        this.description = description;
    }
    
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public Set<Content> getContents() {
        return contents;
    }
    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
