package com.example.wannatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel:ViewModel() {
    val username = MutableLiveData<String>()

    fun setUsername(name: String){
        username.postValue(name)
    }
}