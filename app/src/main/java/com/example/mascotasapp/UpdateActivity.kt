package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import com.example.mascotasapp.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpdateActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

        binding.btnActualizar.setOnClickListener {
            var n_propietario= binding.nPropietario.text.toString()
            var n_Direccion = binding.nuevaDireccion.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                //obtenemos el nombre del propietario
                val propietario = MisMascotasApp.database.propietarioDao().obtenerPropietario(n_propietario)
                //Si existe actualizamos la direccion
                propietario?.let {
                    it.direccion_propietario = n_Direccion
                }
                //Actualizamos propietario en la base de datos
                MisMascotasApp.database.propietarioDao().updatePropietario(propietario)

            }
        }
    }
}