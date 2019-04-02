package com.example.odontologia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun selectConsult(view: View){
        if(view.id == R.id.procedimientos_button){
            val intent = Intent(this, ProcedimientosActivity::class.java).apply {
                putExtra("name", "Procedimientos")
            }
            startActivity(intent)
        }else if (view.id == R.id.materiales_button){
            val intent = Intent(this, MaterialesActivity::class.java).apply {
                putExtra("name", "Materiales")
            }
            startActivity(intent)
        }else if (view.id == R.id.anatomia_button){
            val intent = Intent(this, AnatomiaActivity::class.java).apply {
                putExtra("name", "Anatomia")
            }
            startActivity(intent)
        }else if (view.id == R.id.farmacologia_button){
            val intent = Intent(this, FarmacologiaActivity::class.java).apply {
                putExtra("name", "Farmacologia")
            }
            startActivity(intent)
        }
    }
}
