package com.njm.mdcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.njm.mdcomponents.adapters.ComponentAdapter
import com.njm.mdcomponents.utils.Component
import com.njm.mdcomponents.utils.Constantes
import com.njm.mdcomponents.utils.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {

    @BindView(R.id.recyclerView)
    lateinit var recycler: RecyclerView

    private lateinit var adapter: ComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configAdapter()
        configRecyclerView()
    }

    private fun configRecyclerView() {
        recycler.adapter = adapter
    }

    private fun configAdapter() {
        lateinit var listaComponentes: MutableList<Component>
        adapter = ComponentAdapter(listaComponentes, this)
    }

    /*
    * OnClickListener
    * */
    override fun onClick(component: Component) {
        var intent: Intent
        if (component.type == Constantes.SCROLL){
            intent = Intent(this, ScrollActivity::class.java)
        }else{
            intent = Intent(this, StaticActivity::class.java)
        }
        intent.putExtra(Constantes.ARG_NAME, component.name)
        startActivity(intent)
    }
}
