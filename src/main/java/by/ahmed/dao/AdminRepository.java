package by.ahmed.dao;

import by.ahmed.entity.Admin;

import javax.persistence.EntityManager;

public class AdminRepository extends RepositoryBase<Long, Admin> {

    public AdminRepository(EntityManager entityManager) {
        super(entityManager, Admin.class);
    }
}
