package com.njm.mdcomponents

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import com.njm.mdcomponents.utils.CommonsUtils
import com.njm.mdcomponents.utils.Constantes

import kotlinx.android.synthetic.main.activity_static.*

class StaticActivity : AppCompatActivity() {

    @BindView(R.id.toolbarStatic)
    lateinit var toolbarStatic: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static)
        setSupportActionBar(toolbarStatic)

        var nameFragment: String? = null
        if (savedInstanceState == null){
            nameFragment = intent.getStringExtra(Constantes.ARG_NAME)

            CommonsUtils.setfragment(this, nameFragment, R.id.content_static)
        }

        var actionBar: ActionBar = this!!.supportActionBar!!
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle(nameFragment)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
