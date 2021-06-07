package com.misha_cherdak.kvantorium_rasp.presenter.groups

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val groupsDao by lazy { ScheduleDatabase.gatDatabase(application).scheduleDao() }

    private val _groups = MutableLiveData<List<Group>>()
    val groups: LiveData<List<Group>> get() = _groups

    init {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) { groupsDao.readAllGroups() }
            _groups.value = data
        }
    }

}
