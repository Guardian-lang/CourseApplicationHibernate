package by.ahmed.dao;

import by.ahmed.entity.Comments;

import javax.persistence.EntityManager;

public class CommentsRepository extends RepositoryBase<Long, Comments> {

    public CommentsRepository(EntityManager entityManager) {
        super(entityManager, Comments.class);
    }
}
