package by.ahmed;

import by.ahmed.entity.*;
import by.ahmed.utils.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HibernateTest {

    @Test
    public void addArticleTest() {
        @Cleanup var sessionFactory = HibernateUtil.getConfig().buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var author = Author.builder()
                .firstName("Георгий")
                .lastName("Ахметзянов")
                .gender(Gender.MALE)
                .build();
        session.save(author);

        var theme = Theme.builder()
                .name("Удивительное рядом")
                .build();
        session.save(theme);

        var article = Article.builder()
                .theme(theme)
                .author(author)
                .build();
        session.save(article);

        author.addArticle(article);

        theme.addArticle(article);

        System.out.println();

        session.getTransaction().commit();
    }

    @Test
    public void setAndGetThemesOfAuthorTest() {
        @Cleanup var sessionFactory = HibernateUtil.getConfig().buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        List<Theme> themes = new ArrayList<>();

        var theme1 = Theme.builder()
                .name("IT")
                .build();
        session.save(theme1);

        themes.add(theme1);

        var theme2 = Theme.builder()
                .name("Удивительное рядом")
                .build();
        session.save(theme2);

        themes.add(theme2);

        var author = Author.builder()
                .firstName("Георгий")
                .lastName("Ахметзянов")
                .gender(Gender.MALE)
                .build();
        session.save(author);

        author.setThemes(themes);

        System.out.println(author.getThemes());

        session.getTransaction().commit();
    }

    @Test
    public void getAndSetAuthorsTest() {
        @Cleanup var sessionFactory = HibernateUtil.getConfig().buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        List<Author> authors = new ArrayList<>();

        var author1 = Author.builder()
                .firstName("Георгий")
                .lastName("Ахметзянов")
                .gender(Gender.MALE)
                .build();
        session.save(author1);
        authors.add(author1);

        var author2 = Author.builder()
                .firstName("Игорь")
                .lastName("Якубович")
                .gender(Gender.MALE)
                .build();
        session.save(author2);
        authors.add(author2);

        var theme = Theme.builder()
                .name("IT")
                .build();
        session.save(theme);

        theme.setAuthors(authors);

        System.out.println(theme.getAuthors());

        session.getTransaction().commit();
    }

    @Test
    public void getAndSetUsersTest() {
        @Cleanup var sessionFactory = HibernateUtil.getConfig().buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        List<User> users = new ArrayList<>();

        var user1 = User.builder()
                .ip("")
                .build();
        session.save(user1);
        users.add(user1);

        var user2 = User.builder()
                .ip("")
                .build();
        session.save(user2);
        users.add(user2);

        var theme = Theme.builder()
                .name("IT")
                .build();
        session.save(theme);

        theme.setUsers(users);

        System.out.println(theme.getUsers());

        session.getTransaction().commit();
    }

    @Test
    public void getAndSetThemesOfUserTest() {
        @Cleanup var sessionFactory = HibernateUtil.getConfig().buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        List<Theme> themes = new ArrayList<>();

        var theme1 = Theme.builder()
                .name("IT")
                .build();
        session.save(theme1);

        themes.add(theme1);

        var theme2 = Theme.builder()
                .name("Удивительное рядом")
                .build();
        session.save(theme2);

        themes.add(theme2);

        var user = User.builder()
                .ip("")
                .build();
        session.save(user);

        user.setThemes(themes);

        System.out.println(user.getThemes());

        session.getTransaction().commit();
    }
}
