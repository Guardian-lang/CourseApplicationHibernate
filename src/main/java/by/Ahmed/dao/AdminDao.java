package by.Ahmed.dao;

import by.Ahmed.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Slf4j
public class AdminDao {
    private static final AdminDao INSTANCE = new AdminDao();

    public List<Admin> findByName(String firstName, String lastName) {
        Configuration configuration = new Configuration();
        configuration.configure();
        List<Admin> out;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                var result = session.createQuery("""
                        select a from Admin a
                        where a.firstName = :firstname
                        and a.lastName = :lastname
                        """, Admin.class)
                        .setParameter("firstname", firstName)
                        .setParameter("lastname", lastName)
                        .list();
                System.out.println(result);
                log.info("Admin found");
                out = result;

                session.getTransaction().commit();
                session.close();
                return out;
            }
        } catch (Exception e) {
            log.error("Admin not found");
            return null;
        }
    }
}
