package com.example.withplaceprototype.domain.match.domain.repository;

import com.example.withplaceprototype.domain.match.domain.entity.Lawd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LawdRepository extends JpaRepository<Lawd,Long> {

    @Query(value = "select l.lawdCd from Lawd l where l.lawdDong=:lawdDong")
    String findLawdCd(@Param("lawdDong") String lawdDong);
}
