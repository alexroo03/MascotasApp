package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DeleteActivity: ActivityWithMenu() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btonEliminar.setOnClickListener{
            var n_propietario= binding.escribePropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                var listaMascotas = MisMascotasApp.database.propietarioDao().mascotasdeunpropietario(n_propietario)

                for(i in 0  until  listaMascotas.mascotas.size){
                    MisMascotasApp.database.mascotasDao().eliminarMascota(listaMascotas.mascotas[i])
                }

                var aut = MisMascotasApp.database.propietarioDao().obtenerPropietario(n_propietario)

                MisMascotasApp.database.propietarioDao().eliminarPropietario(aut)
            }
        }



    }
}