package by.Ahmed.entity;

import by.Ahmed.converter.BirthdayConverter;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"themes", "articles", "trashArticles"})
@Builder
@Entity
@Table(name = "author")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Author implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Convert(converter = BirthdayConverter.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    private String occupation;
    @Column(name = "job_title")
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private CheckStatus checkStatus;
    private String about;
    private String email;
    private String password;

    @Builder.Default
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
        article.setAuthor(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_themes",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private List<Theme> themes = new ArrayList<>();

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @OneToMany
    @JoinTable(name = "trash_can",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> trashArticles = new ArrayList<>();
}
