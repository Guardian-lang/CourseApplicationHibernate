package by.Ahmed.dao;

import by.Ahmed.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Slf4j
public class UserDao {
    private static final UserDao INSTANCE = new UserDao();

    public List<User> findByIp(String ip) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<User> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select u from User u
                        where u.ip = :ip
                        """, User.class)
                        .setParameter("ip", ip)
                        .list();
                System.out.println(result);
                log.info("Users found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Users not found");
            return null;
        }
    }
}
