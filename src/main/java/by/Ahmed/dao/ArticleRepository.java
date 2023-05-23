package by.Ahmed.dao;

import by.Ahmed.entity.Article;

import javax.persistence.EntityManager;

public class ArticleRepository extends RepositoryBase<Long, Article> {

    public ArticleRepository(EntityManager entityManager) {
        super(entityManager, Article.class);
    }
}
