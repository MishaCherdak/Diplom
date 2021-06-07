package com.misha_cherdak.kvantorium_rasp.presenter.teacher

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.misha_cherdak.kvantorium_rasp.core.livedata.LiveEvent
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Prep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeachersViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val teachersDao by lazy { ScheduleDatabase.gatDatabase(application).scheduleDao() }

    private val _teachers = MutableLiveData<List<Prep>>()
    val teachers: LiveData<List<Prep>> get() = _teachers

    private val _eventOpenTeacherSchedule = LiveEvent<Int>()
    val eventOpenTeacherSchedule: LiveData<Int> get() = _eventOpenTeacherSchedule

    init {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) { teachersDao.getAllTeachers() }
            _teachers.value = data
        }
    }

    fun onTeacherClick(teacher: Prep) {
        _eventOpenTeacherSchedule.postValue(teacher.id_prep)
    }

}
