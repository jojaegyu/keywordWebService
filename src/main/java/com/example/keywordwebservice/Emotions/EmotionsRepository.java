package com.example.keywordwebservice.Emotions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmotionsRepository extends JpaRepository<Emotions, Long> {
    Optional<Emotions> findByKeyword(String keyword);
}
