package by.ahmed.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"themes", "comments", "articles"})
@Builder
@Entity
@Table(name = "user")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_ip")
    private String ip;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Comments> comments = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recommended_themes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private List<Theme> themes = new ArrayList<>();

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @OneToMany(mappedBy = "user")
    @JoinTable(name = "user_history",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> articles = new ArrayList<>();
}
