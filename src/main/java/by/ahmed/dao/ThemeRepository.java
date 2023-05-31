package by.ahmed.dao;

import by.ahmed.entity.Theme;

import javax.persistence.EntityManager;

public class ThemeRepository extends RepositoryBase<Long, Theme> {

    public ThemeRepository(EntityManager entityManager) {
        super(entityManager, Theme.class);
    }
}
