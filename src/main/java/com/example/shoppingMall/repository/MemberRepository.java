package com.example.shoppingMall.repository;

import com.example.shoppingMall.entity.Delivery;
import com.example.shoppingMall.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepository {

    private final EntityManagerFactory emf;

    public Long save(Member member) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

            em.persist(member);
            tx.commit();

            return em.find(Member.class, member.getId()).getId();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        return null;
    }

    public void saveDelivery(Long memberId, String address){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = em.find(Member.class, memberId);

        Delivery delivery = Delivery.saveDelivery(member, address);

        tx.begin();
        try{
            em.persist(delivery);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    public Member findOne(Long id){
        EntityManager em = emf.createEntityManager();
        Member findMember = em.find(Member.class, id);
        em.close();
        return findMember;
    }

    public Member findByMemberId(String memberId){
        EntityManager em = emf.createEntityManager();
        Member findMember = (Member) em.createQuery("select m from Member m where m.memberId = :id")
                                        .setParameter("id", memberId)
                                        .getSingleResult();
        em.close();
        return findMember;
    }

    public Delivery findMemberDelivery(Long id){
        EntityManager em = emf.createEntityManager();
        Delivery findDelivery = (Delivery) em.createQuery("select d from Delivery d where d.member.id = :id", Delivery.class)
                                            .setParameter("id", id)
                                            .getSingleResult();
        em.close();
        return findDelivery;
    }
}
