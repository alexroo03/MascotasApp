package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MostrarActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMostrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMostrar.setOnClickListener{
            var propietario_introducido=binding.nPropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                var listaMascotas = MisMascotasApp.database.propietarioDao().mascotasdeunpropietario(propietario_introducido)
                var listaPerros = 0
                var listaGatos = 0

                //siempre que la mascota que seleccionamos sea perro, se añadira un elemento mas a perro sino se incrementara la de gato
                listaMascotas.mascotas.forEach { mascota ->
                    if (mascota.esPerro) {
                        listaPerros+1
                    } else {
                        listaGatos+1
                    }
                }

                //Actualizamos el textbox con los nuevos parametros
                runOnUiThread {
                    binding.numPerros.text = listaPerros.toString()
                    binding.numGatos.text = listaGatos.toString()
                }

            }

        }
    }
}