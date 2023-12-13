package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface PropietarioDAO {
    @Insert
    fun anadirPropietario(propietarios: Propietarios)

    @Transaction
    @Query("SELECT * FROM propietarios WHERE nombre_propietario like :propietario")
    fun mascotasdeunpropietario(propietario: String): PropietarioConMascota

    @Query("SELECT * FROM propietarios WHERE nombre_propietario like :propietario")
    fun obtenerPropietario(propietario: String): Propietarios

    @Delete
    fun eliminarPropietario(propietarios: Propietarios)

    @Update
    fun updatePropietario(propietarios: Propietarios)
}

