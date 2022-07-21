package com.example.keywordwebservice.Configuration;

import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
public class MongoConfiguration {


    public class MongoConfig{

        @Value("${spring.data.mongodb.host}")
        private String mongoHost;

        @Value("${spring.data.mongodb.port}")
        private String mongopPort;

        @Value("${spring.data.mongodb.database}")
        private String mongoDB;

        /*Client vs FactoryClient
         *
         * Factory bean that creates the com.mongodb.MongoClient instance
         *
         * Classes attributed with @Repostiory may throw mongo related exceptions. Declaring an instance of MonogClientFactoryBean
         * helps in translating them to spring data exceptions which can then be caught using @ExceptionHandling
         * */
//        public @Bean MongoClientFactoryBean mongo() throws Exception {
//            MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//            mongo.setHost("localhost");
//            return mongo;
//        }
    }
}


