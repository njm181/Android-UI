package com.njm.mdcomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.njm.mdcomponents.R
import com.njm.mdcomponents.utils.Component
import com.njm.mdcomponents.utils.OnClickListener

class ComponentAdapter(listComponents: MutableList<Component>, listener: OnClickListener) : RecyclerView.Adapter<ComponentAdapter.ViewHolder>() {

    private  var listaComponents: MutableList<Component> = listComponents
    private  var onclicklistener: OnClickListener = listener



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_component, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaComponents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val component: Component = listaComponents.get(position)

        holder.setClickListener(onclicklistener, component)

        holder.tvName.text = component.name
        holder.imgPhoto.setImageResource(component.photoRes)

    }

    fun addComponent(component: Component){
        if (!listaComponents.contains(component)){
            listaComponents.add(component)
            notifyItemInserted(listaComponents.size - 1)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        @BindView(R.id.imgPhoto)
        lateinit var imgPhoto: ImageView
        @BindView(R.id.tvName)
        lateinit var tvName: TextView

        var view: View

        init {
            view = itemView
            ButterKnife.bind(this, itemView)
        }

        fun setClickListener(listener: OnClickListener, component: Component){
            view.setOnClickListener { v -> listener.onClick(component) }
        }
    }
}