package com.njm.mdcomponents.utils
class Component (nombre: String, phRes: Int, tipo: Int){

    val name: String = nombre
    val photoRes: Int = phRes
    val type: Int = tipo

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


}

