package com.pikecape.testing.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("duck")
data class DuckEntity(
    @Id
    var uid: UUID = UUID.randomUUID(),
    var name: String? = null
)
