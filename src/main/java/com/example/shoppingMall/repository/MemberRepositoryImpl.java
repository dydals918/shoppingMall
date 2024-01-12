package com.example.shoppingMall.repository;

import com.example.shoppingMall.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final EntityManagerFactory emf;

    @Override
    @Transactional
    public Long save(Member member) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            em.persist(member);
            tx.commit();
            Member createMember = em.find(Member.class, member.getId());
            return createMember.getId();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        return null;
    }
}
