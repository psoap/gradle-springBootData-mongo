//package net.psoap.config;
//
//import com.mongodb.MongoClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//
//@Configuration
//public class DataConfig extends AbstractMongoConfiguration {
//    @Override
//    @Bean
//    public MongoClient mongoClient() {
//        return new MongoClient("127.0.0.1");
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "news";
//    }
//}
