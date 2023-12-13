package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.example.mascotasapp.database.Mascotas
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Funciones para el boton de guardar
        binding.btnGuardar.setOnClickListener{
            //Valores Propietarios
            var n_propietario = binding.nombrePropietario.text.toString()
            var d_propietario = binding.direccionPropietario.text.toString()
            var t_propietario = binding.telefonoPropietario.text.toString()
            //Valores Mascotas
            var n_mascota = binding.nombreMascota.text.toString()
            var r_mascota = binding.razaMascota.text.toString()
            var f_nacimiento = binding.fechaNacMascota.text.toString()

            val radioGroup = findViewById<RadioGroup>(R.id.grupo_radio)
            val botonSeleccionado = radioGroup.checkedRadioButtonId
            val esPerro = botonSeleccionado == R.id.radioPerro

            CoroutineScope(Dispatchers.IO).launch {
                MisMascotasApp.database.propietarioDao().anadirPropietario(
                    Propietarios(
                        nombre_propietario = n_propietario,
                        direccion_propietario = d_propietario,
                        tlf_propietario = t_propietario,
                    )
                )

                MisMascotasApp.database.mascotasDao().anadirMascota(
                    Mascotas(
                        nombre = n_mascota,
                        raza = r_mascota,
                        fecha_nacimiento = f_nacimiento,
                        esPerro = esPerro,
                        duenio = n_propietario


                    )
                )
            }
            runOnUiThread { binding.nombreMascota.setText("")
                binding.razaMascota.setText("")
                binding.fechaNacMascota.setText("") }

        }

        //Funciones para el boton de mostrar mascota
        binding.btnOtraMascota.setOnClickListener{
            //Valores Mascotas
            var n_mascota = binding.nombreMascota.text.toString()
            var r_mascota = binding.razaMascota.text.toString()
            var f_nacimiento = binding.fechaNacMascota.text.toString()
            var n_propietario = binding.nombrePropietario.text.toString()

            val radioGroup = findViewById<RadioGroup>(R.id.grupo_radio)
            val botonSeleccionado = radioGroup.checkedRadioButtonId
            val esPerro = botonSeleccionado == R.id.radioPerro

            CoroutineScope(Dispatchers.IO).launch {
                MisMascotasApp.database.mascotasDao().anadirMascota(
                    Mascotas(
                        nombre = n_mascota,
                        raza = r_mascota,
                        fecha_nacimiento = f_nacimiento,
                        esPerro = esPerro,
                        duenio = n_propietario

                    )
                )
            }
        }
    }
}