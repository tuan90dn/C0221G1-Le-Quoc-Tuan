package com.model.repository.img_repository;

import com.model.entity.Image;
import com.model.repository.BaseRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ImageRepository implements IImgRepository {

    @Override
    public List<Image> findAll() {
        return BaseRepository.entityManager.createNativeQuery("select * from image i where i.date_comment=curdate();",Image.class).getResultList();
//        String queryStr = "SELECT c FROM Image AS c ";
//        TypedQuery<Image> query = BaseRepository.entityManager.createQuery(queryStr, Image.class);
//        return query.getResultList();
    }

    @Override
    public Image findById(int id) {
        String queryStr = "SELECT c FROM Image AS c WHERE c.id = :id";
        TypedQuery<Image> query = BaseRepository.entityManager.createQuery(queryStr, Image.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Image model) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(model);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {

    }
}
