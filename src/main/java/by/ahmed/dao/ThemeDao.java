package by.ahmed.dao;

import by.ahmed.entity.Theme;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Slf4j
public class ThemeDao {
    private static final ThemeDao INSTANCE = new ThemeDao();

    public List<Theme> findByName(String name) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Theme> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select t from Theme t
                        where t.name = :name
                        """, Theme.class)
                        .setParameter("name", name)
                        .list();
                System.out.println(result);
                log.info("Themes found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Themes not found");
            return null;
        }
    }

    public static ThemeDao getInstance() {
        return INSTANCE;
    }
}
