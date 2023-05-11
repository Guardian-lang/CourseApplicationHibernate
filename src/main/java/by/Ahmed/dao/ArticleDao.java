package by.Ahmed.dao;

import by.Ahmed.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

@Slf4j
public class ArticleDao {
    private static final ArticleDao INSTANCE = new ArticleDao();

    public List<Article> findByAuthor(String firstName, String lastName) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Article> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Article a
                        left join Author au
                        where au.firstName = :firstname
                        and au.lastName = :lastname
                        """, Article.class)
                        .setParameter("firstname", firstName)
                        .setParameter("lastname", lastName)
                        .list();
                System.out.println(result);
                log.info("Article found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Article not found");
            return null;
        }
    }

    public List<Article> findByDate(LocalDate date) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Article> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Article a
                        where a.date = :date
                        """, Article.class)
                        .setParameter("date", date)
                        .list();
                System.out.println(result);
                log.info("Article found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Article not found");
            return null;
        }
    }
}
