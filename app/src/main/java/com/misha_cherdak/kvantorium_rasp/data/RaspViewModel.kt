package com.misha_cherdak.kvantorium_rasp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.misha_cherdak.kvantorium_rasp.data.Entity.Gryp

class RaspViewModel(application: Application): AndroidViewModel(application) {

    private val readAllGryp: LiveData<List<Gryp>>
    private val repository: RaspRepository

    init {
        val raspDao = RaspDatabase.gatDatabase(application).raspDao()
        repository = RaspRepository(raspDao)
        readAllGryp = repository.readAllGryp
    }

}