package com.njm.mdcomponents.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class CommonsUtils {

    companion object{
        fun setfragment(activity: AppCompatActivity, nameFragment: String, contentRes: Int){
            var fragment : Fragment? = getFragmentById(nameFragment)

            activity.supportFragmentManager.beginTransaction().add(contentRes, fragment!!).commit()
        }

        private fun getFragmentById(nameFragment: String): Fragment? {
            var fragment: Fragment? = null

            when(nameFragment){
                //SCROLL

                //STATIC
            }
            return fragment
        }
    }
}