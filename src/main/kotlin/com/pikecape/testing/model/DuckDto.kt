package com.pikecape.testing.model

import java.util.UUID

data class DuckDto (
    val uid: UUID = UUID.randomUUID(),
    var name: String? = null
)
