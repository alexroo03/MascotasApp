package com.example.mascotasapp

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenu: AppCompatActivity() {
    companion object {
        var actividadActual =1;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Relacionamos la clase con el layout del menú que hemos creado:
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.anadir->  {
                actividadActual = 1
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.mostrar -> {
                actividadActual = 2
                val intent = Intent(this, MostrarActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.eliminar -> {
                actividadActual = 3
                val intent = Intent(this, DeleteActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.actualizar -> {
                actividadActual = 4
                val intent = Intent(this, UpdateActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}