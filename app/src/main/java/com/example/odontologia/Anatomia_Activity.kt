package com.example.odontologia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_anatomia.*
import kotlinx.android.synthetic.main.activity_anatomia_.*
import org.w3c.dom.Text
import java.io.Serializable

class Anatomia_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anatomia_)
        val anatomia = intent.getSerializableExtra("anatomia") as Anatomia;

        loadAnimales(anatomia)
    }

    private fun loadAnimales(anatomia: Anatomia) {
        val nombre: TextView
        val descripcion: TextView
        val nomenclatura: TextView
        val erupcion: TextView
        val image: ImageView
        nombre = findViewById(R.id.nombre)
        descripcion = findViewById(R.id.descripcion)
        nomenclatura = findViewById(R.id.nomenclatura)
        erupcion = findViewById(R.id.erupcion)

        image = findViewById(R.id.anatomia)
        val option = RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card)
        nombre.setText(anatomia.nombre)
        descripcion.setText(anatomia.descripcion)
        nomenclatura.setText(anatomia.nomenclatura)
        erupcion.setText(anatomia.erupcion)
        Glide.with(this).load(anatomia.imagen).apply(option).into(image)
    }
}
data class Anatomia(
    val imagen: String = "",
    val nombre: String = "",
    val nomenclatura: String = "",
    val erupcion: String = "",
    val descripcion: String = ""
):Serializable