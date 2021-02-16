package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface URLShortnerRepo extends JpaRepository<URLShortnerModule,Integer> {

    @Query(value="SELECT * from techify_project where short_url = :short_url_check LIMIT 1", nativeQuery= true)
    public Optional<URLShortnerModule> findByLong_url(String short_url_check);
}
