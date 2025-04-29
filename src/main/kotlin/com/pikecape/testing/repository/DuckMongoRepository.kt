package com.pikecape.testing.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DuckMongoRepository : MongoRepository<DuckEntity, UUID?> {}
