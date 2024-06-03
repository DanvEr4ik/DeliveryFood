package com.example.fooddelivery.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedModel : ViewModel(){
    val cartItem = MutableLiveData<ArrayList<PopularModel>>()
    val buttonStates = ArrayList<Boolean>()

    fun getButtonStates(): List<Boolean>{
        return buttonStates
    }

    fun addToCart(item : PopularModel){
        val currentCartItem = cartItem.value ?: ArrayList<PopularModel>()
        currentCartItem.add(item)
        cartItem.value = currentCartItem
        buttonStates.add(true)
    }

    fun deleteFromCart(item: PopularModel){
        val currentCartItem = cartItem.value ?: ArrayList<PopularModel>()
        val index = currentCartItem.indexOf(item)
        if(index != -1){
            currentCartItem.removeAt((index))
            cartItem.value = currentCartItem
            buttonStates.removeAt(index)
        }
    }

    fun inList(item: PopularModel): Boolean{
        val currentCartItem = cartItem.value ?: ArrayList<PopularModel>()
        return currentCartItem.contains(item)
    }
}

