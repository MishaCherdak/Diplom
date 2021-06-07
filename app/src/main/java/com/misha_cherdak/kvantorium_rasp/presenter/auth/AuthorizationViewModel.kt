package com.misha_cherdak.kvantorium_rasp.presenter.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.misha_cherdak.kvantorium_rasp.core.livedata.LiveEvent
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Admin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorizationViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val adminsDao by lazy { ScheduleDatabase.gatDatabase(application).scheduleDao() }
    private var admins = emptyList<Admin>()

    private val _eventErrorAuth = LiveEvent<Unit>()
    val eventErrorAuth: LiveData<Unit> get() = _eventErrorAuth

    private val _eventOpenSome = LiveEvent<Unit>()
    val eventOpenSome: LiveData<Unit> get() = _eventOpenSome

    init {
        viewModelScope.launch {
            admins = withContext(Dispatchers.IO) { adminsDao.getAllAdmins() }
        }
    }

    fun onAuthClick(login: String, password: String) {
        val isSuccessful = admins.any { it.login == login && it.Pass == password }
        if (isSuccessful) _eventOpenSome.postValue(Unit) else _eventErrorAuth.postValue(Unit)
    }
}