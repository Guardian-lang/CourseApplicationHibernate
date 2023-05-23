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
@ToString(exclude = {"bannedAuthors", "trashArticles"})
@Builder
@Entity
@Table(name = "admin")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Admin implements BaseEntity<Long> {
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
    @Column(name = "admin_rules")
    @Enumerated(EnumType.STRING)
    private AdminRule adminRule;

    @Builder.Default
    @OneToMany
    @JoinTable(name = "banned",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> bannedAuthors = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "trash_can",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> trashArticles = new ArrayList<>();
}
