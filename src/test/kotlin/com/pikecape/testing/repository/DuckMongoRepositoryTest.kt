package com.pikecape.testing.repository

import com.pikecape.testing.AbstractMongoRepositoryTest
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DuckMongoRepositoryTest : AbstractMongoRepositoryTest() {
    @Autowired
    lateinit var repository: DuckMongoRepository

    val duey = DuckEntity(
        name = "Duey"
    )

    val huey = DuckEntity(
        name = "Huey"
    )

    val luey = DuckEntity(
        name = "Luey"
    )

    @BeforeEach
    fun setUp () {
        repository.deleteAll();
    }

    @Test
    fun testFindAll () {
        repository.save(duey);
        repository.save(huey);
        repository.save(luey);

        val result = repository.findAll();

        assertEquals(3, result.size);
    }

    @Test
    fun testFindByUid() {
        val created = repository.save(duey);

        val result = repository.findById(created.uid).orElse(null);

        assertNotNull(result);
        assertEquals(duey.name, result.name);
    }

    @Test
    fun testCreate() {
        val result = repository.save(duey);

        assertEquals(duey.name, result.name);
    }

    @Test
    fun testUpdate() {
        val created = repository.save(duey);

        created.name = "Tupu";

        repository.save(created);

        val result = repository.findById(created.uid).orElse(null);

        assertNotNull(result);
        assertEquals("Tupu", result.name);
    }

    @Test
    fun testDelete() {
        val created = repository.save(duey);

        assertEquals(1, repository.findAll().size);

        repository.delete(created);

        assertEquals(0, repository.findAll().size);
    }
}
