package com.example.withplaceprototype.domain.match.domain.repository;

import com.example.withplaceprototype.domain.match.domain.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
