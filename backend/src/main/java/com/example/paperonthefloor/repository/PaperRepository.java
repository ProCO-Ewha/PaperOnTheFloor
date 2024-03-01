package com.example.paperonthefloor.repository;

import com.example.paperonthefloor.domain.Paper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaperRepository {

    private final EntityManager em;

    @Transactional
    public void save(Paper paper) {
        em.persist(paper);
    }

    public Paper findOne(Long id) {
        return em.find(Paper.class, id);
    }

    public List<Paper> findDiariesByIdAndDate(int year, int month, int day) {
        String jpql = "SELECT d FROM Paper d " +
                "WHERE YEAR(d.date) = :year " +
                "AND MONTH(d.date) = :month " +
                "AND DAY(d.date) = :day";
        return em.createQuery(jpql, Paper.class)
                .setParameter("year", year)
                .setParameter("month", month)
                .setParameter("day", day)
                .getResultList();
    }
}
