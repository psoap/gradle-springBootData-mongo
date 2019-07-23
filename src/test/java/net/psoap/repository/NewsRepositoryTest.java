package net.psoap.repository;

import net.psoap.Application;
import net.psoap.model.News;
import org.assertj.core.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NewsRepositoryTest {

    @Autowired
    private NewsRepository newsRepository;

    @Test
    public void findNewsByDateTest_shouldReturnsNotNullNews(){
        News news = News.builder()
                .title("title")
                .content("top content")
                .date(LocalDate.now())
                .build();

        newsRepository.insert(news);

        System.out.println(news);
        System.out.println(newsRepository.findNewsByDate(news.getDate()));

        assertTrue(newsRepository.findNewsByDate(news.getDate()).contains(news));
    }

    @Test
    public void findNewsByPeaceOfTitleTest_shouldReturnsNotNullNews(){
        News news = News.builder()
                .title("qwerty dasd as d sada ")
                .content("top content")
                .date(LocalDate.now())
                .build();

        newsRepository.insert(news);
        List<News> newsList = Collections.singletonList(news);

        System.out.println(news);
        System.out.println(newsRepository.customQuery("as"));

        assertEquals(newsList, newsRepository.customQuery("as"));
    }
}