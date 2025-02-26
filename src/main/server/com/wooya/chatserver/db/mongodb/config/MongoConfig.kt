package com.wooya.chatserver.db.mongodb.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoConfig {

    @Bean
    fun mongoClient(): MongoClient {
        val connectionString = ConnectionString("mongodb+srv://ksswy79:!Q2w3e4r5t@wooyamongodb.hpuxa.mongodb.net/Messenger?retryWrites=true&w=majority")
        val settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()
        return MongoClients.create(settings);
    }

    @Bean
    fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoClient(), "wooyaMongoDb")
    }
}