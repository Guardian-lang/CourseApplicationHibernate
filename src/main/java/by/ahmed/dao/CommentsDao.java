package by.ahmed.dao;

import by.ahmed.entity.Comments;
import by.ahmed.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Slf4j
public class CommentsDao {
    private static final CommentsDao INSTANCE = new CommentsDao();

    public List<Comments> findByUser(User user) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Comments> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select c from Comments c
                        left join User u
                        where u.id = :userId
                        and u.ip = :userIp
                        """, Comments.class)
                        .setParameter("userId", user.getId())
                        .setParameter("userIp", user.getIp())
                        .list();
                System.out.println(result);
                log.info("Comments found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Comments not found");
            return null;
        }
    }

    public static CommentsDao getInstance() {
        return INSTANCE;
    }
}
