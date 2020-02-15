package com.njm.mdcomponents

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.njm.mdcomponents.utils.CommonsUtils
import com.njm.mdcomponents.utils.Constantes

class ScrollActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.fab)
    lateinit var fab : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        var nameFragment: String? = null
        if (savedInstanceState == null){
            nameFragment = intent.getStringExtra(Constantes.ARG_NAME)

            CommonsUtils.setfragment(this, nameFragment, R.id.content_scroll)
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
