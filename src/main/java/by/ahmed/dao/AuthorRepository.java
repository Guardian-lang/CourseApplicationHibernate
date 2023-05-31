package by.ahmed.dao;

import by.ahmed.entity.Author;

import javax.persistence.EntityManager;

public class AuthorRepository extends RepositoryBase<Long, Author> {

    public AuthorRepository(EntityManager entityManager) {
        super(entityManager, Author.class);
    }
}
