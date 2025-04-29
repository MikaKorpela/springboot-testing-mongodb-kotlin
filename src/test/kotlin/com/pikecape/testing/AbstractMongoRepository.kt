package com.pikecape.testing

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.function.Supplier


@Testcontainers
@SpringBootTest(classes = [Application::class])
abstract class AbstractMongoRepositoryTest {
    companion object {
        @Container
        @JvmStatic
        val mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:latest").apply { start() }

        @JvmStatic
        @DynamicPropertySource
        fun containersProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri", Supplier { mongoDBContainer.replicaSetUrl })
        }
    }
}
