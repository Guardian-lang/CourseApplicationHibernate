package by.Ahmed.dao;

import by.Ahmed.entity.Theme;

import javax.persistence.EntityManager;

public class ThemeRepository extends RepositoryBase<Long, Theme> {

    public ThemeRepository(EntityManager entityManager) {
        super(entityManager, Theme.class);
    }
}
