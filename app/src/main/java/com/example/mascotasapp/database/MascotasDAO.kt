package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface MascotasDAO {

    @Insert
    fun anadirMascota(mascotas: Mascotas)

    @Delete
    fun eliminarMascota(mascotas: Mascotas)

    @Update
    fun updateMascota(mascotas: Mascotas)

}

