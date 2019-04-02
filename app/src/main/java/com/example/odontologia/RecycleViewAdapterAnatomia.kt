package com.example.odontologia

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecycleViewAdapterAnatomia(private val list: MutableList<Anatomia>?,val context: Context) :
    RecyclerView.Adapter<RecycleViewAdapterAnatomia.AnatomiaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnatomiaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_anatomia_,parent,false)
        val anatomiaViewHolder =  AnatomiaViewHolder(inflater, parent,context)
        anatomiaViewHolder.itemView.setOnClickListener {
            val info = list!!.get(anatomiaViewHolder.adapterPosition)
            val intent= Intent(context, Anatomia_Activity::class.java)
            intent.putExtra("anatomia",info)
            context.startActivity(intent)
        }
        return anatomiaViewHolder
    }

    override fun onBindViewHolder(holder: AnatomiaViewHolder, position: Int) {
        val anatomia: Anatomia = list!![position]
        holder.bind(anatomia)

    }

    override fun getItemCount(): Int = list!!.size

    class AnatomiaViewHolder(inflater: LayoutInflater, parent: ViewGroup,context: Context) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.activity_anatomia_, parent, false)) {
        private var anatomiaNameTextView: TextView? = null
        private var anatomiaDescrptionView: TextView? = null
        private var anatomiaErupcionView: TextView? = null
        private var anatomiaNomenclaturaView: TextView? = null
        private var anatomiaImageView: ImageView?=null
        val context=context

        init {
            anatomiaNameTextView = itemView.findViewById(R.id.nombre)
            anatomiaNomenclaturaView = itemView.findViewById(R.id.nomenclatura)
            anatomiaErupcionView = itemView.findViewById(R.id.erupcion)
            anatomiaDescrptionView = itemView.findViewById(R.id.descripcion)
            anatomiaImageView =itemView.findViewById(R.id.anatomia)
        }

        fun bind(anatomia: Anatomia) {

            anatomiaNameTextView?.text = anatomia.nombre
            anatomiaNomenclaturaView?.text = anatomia.nomenclatura
            anatomiaErupcionView?.text = anatomia.erupcion
            anatomiaDescrptionView?.text = anatomia.descripcion
            val option = RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card)
            Glide.with(context).load(anatomia.imagen).apply(option).into(anatomiaImageView!!)
        }

    }
}
