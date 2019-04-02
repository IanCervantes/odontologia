package com.example.odontologia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_anatomia.*
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList


class AnatomiaActivity : AppCompatActivity() {

    private var dientes: MutableList<Anatomia>? = null
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anatomia)
        dientes = ArrayList<Anatomia>()
        recyclerView = findViewById(R.id.anatomia_recycleView)
        anatomia_recycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecycleViewAdapterAnatomia(mutableListOf<Anatomia>(),context)
        }
        FirebaseApp.initializeApp(this);
        getProduct()
    }


    private fun getProduct(){
        val refFirebase= FirebaseDatabase.getInstance().getReference("/anatomia")
        refFirebase.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                val lista= mutableListOf<Anatomia>()
                p0.children.forEach{
                    val producto=it.getValue(Anatomia::class.java)
                    lista.add(producto!!)
                }
                anatomia_recycleView.adapter=RecycleViewAdapterAnatomia(lista,this@AnatomiaActivity)
            }
        })
    }

    private fun setRecyclerView(anatomia: MutableList<Anatomia>?) {
        val recycleViewAdapter = RecycleViewAdapterAnatomia(anatomia,this )
        recyclerView?.setLayoutManager(LinearLayoutManager(this))
        recyclerView?.setAdapter(recycleViewAdapter)
    }
}


