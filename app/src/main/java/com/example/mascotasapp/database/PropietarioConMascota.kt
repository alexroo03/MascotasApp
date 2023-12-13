package com.example.mascotasapp.database

import androidx.room.Embedded
import androidx.room.Relation

data class PropietarioConMascota (
    @Embedded val propietarios: Propietarios,
    @Relation(
        parentColumn = "nombre_propietario",
        entityColumn = "id"
    )
    val mascotas: MutableList<Mascotas>
)