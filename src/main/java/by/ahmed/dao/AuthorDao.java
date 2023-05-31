package by.ahmed.dao;

import by.ahmed.entity.Article;
import by.ahmed.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

@Slf4j
public class AuthorDao {
    private static final AuthorDao INSTANCE = new AuthorDao();

    public List<Author> findByName(String firstName, String lastName) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Author> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Author a
                        where a.firstName = :firstname
                        and a.lastName = :lastname
                        """, Author.class)
                        .setParameter("firstname", firstName)
                        .setParameter("lastname", lastName)
                        .list();
                System.out.println(result);
                log.info("Author found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Author not found");
            return null;
        }
    }

    public List<Author> findByArticle(Article article) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Author> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Author a
                        left join Article ar
                        where ar.title = :article
                        """, Author.class)
                        .setParameter("article", article.getTitle())
                        .list();
                System.out.println(result);
                log.info("Author found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Author not found");
            return null;
        }
    }

    public List<Author> findByEmail(String email) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Author> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Author a
                        where a.email = :email
                        """, Author.class)
                        .setParameter("email", email)
                        .list();
                System.out.println(result);
                log.info("Author found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Author not found");
            return null;
        }
    }

    public Optional<Author> findByEmailAndPassword(String email, String password) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Author> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Author a
                        where a.email = :email
                        and a.password = :password
                        """, Author.class)
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .list();
                System.out.println(result);
                log.info("Author found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return Optional.ofNullable(out.get(0));
            }
        } catch (Exception e) {
            log.error("Author not found");
            return null;
        }
    }

    public static AuthorDao getInstance() {
        return INSTANCE;
    }
}
