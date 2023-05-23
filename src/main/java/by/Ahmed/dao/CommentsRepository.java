package by.Ahmed.dao;

import by.Ahmed.entity.Comments;

import javax.persistence.EntityManager;

public class CommentsRepository extends RepositoryBase<Long, Comments> {

    public CommentsRepository(EntityManager entityManager) {
        super(entityManager, Comments.class);
    }
}
