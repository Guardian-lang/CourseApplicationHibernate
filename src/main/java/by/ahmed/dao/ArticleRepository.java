package by.ahmed.dao;

import by.ahmed.entity.Article;

import javax.persistence.EntityManager;

public class ArticleRepository extends RepositoryBase<Long, Article> {

    public ArticleRepository(EntityManager entityManager) {
        super(entityManager, Article.class);
    }
}
