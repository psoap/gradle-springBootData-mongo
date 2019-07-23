package net.psoap.repository;

import net.psoap.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {

    @Query(value = "{title: {$regex:'.*?0.*', $options:'i'}}")
    List<News> customQuery(String peaceOfTitle);

    List<News> findNewsByDate(LocalDate date);
}