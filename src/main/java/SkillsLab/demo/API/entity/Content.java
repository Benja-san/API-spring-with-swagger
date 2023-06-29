package SkillsLab.demo.API.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @NotBlank
    @Size(max = 255)
    private String title;
    @NotBlank
    @Size(max = 255)
    private String slug;
    @NotBlank
    @Size(max = 255)
    private String intro;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    @JsonIgnore
    private Category category;
    @Transient
    private long categoryId;
    @Transient
    private String categoryName;

    public Content() {
    }

    public Content(
        String title,
        String intro,
        String content
    ) {
        this.title = title;
        this.intro = intro;
        this.content = content;
    }
    
    public long getId() {
        return id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public long getCategoryId() {
        return category.getId();
    }

    public String getCategoryName() {
        return category.getName();
    }
}
