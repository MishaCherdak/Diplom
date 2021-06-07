package com.misha_cherdak.kvantorium_rasp.presenter.schedule

import android.app.Application
import android.os.Parcelable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.entity.fullName
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.FullScheduleInfo
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.ScheduleViewType.*
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.entity.ScheduleItem
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class ScheduleViewType : Parcelable {

    @Parcelize
    object All : ScheduleViewType()

    @Parcelize
    data class ByGroup(
        val groupId: Int
    ) : ScheduleViewType()

    @Parcelize
    data class ByTeacher(
        val teacherId: Int
    ) : ScheduleViewType()

}

class ScheduleViewModel(
    application: Application,
    private val viewType: ScheduleViewType
) : AndroidViewModel(application) {

    private val scheduleDao by lazy { ScheduleDatabase.gatDatabase(application).scheduleDao() }
    private lateinit var fullSchedule: Map<Int, List<ScheduleItem>>

    private val _schedule = MutableLiveData<List<ScheduleItem>>()
    val schedule: LiveData<List<ScheduleItem>> get() = _schedule

    private val _currentDay = MutableLiveData(1)
    val currentDay: LiveData<Int> get() = _currentDay

    init {
        viewModelScope.launch {
            fullSchedule = withContext(Dispatchers.IO) {
                val data = when (viewType) {
                    All -> emptyList()
                    is ByGroup -> scheduleDao.getSchedulesByGroup(viewType.groupId)
                    is ByTeacher -> scheduleDao.getScheduleByTeacher(viewType.teacherId)
                }
                data
                    .groupBy { it.day.id_day }
                    .mapValues { entry -> entry.value.map { it.toScheduleItem(viewType) } }
            }
            _schedule.value = fullSchedule[_currentDay.value ?: 1].orEmpty()
        }
    }

    fun onDayClick(dayId: Int) {
        if (!this::fullSchedule.isInitialized) return

        _schedule.value = fullSchedule[dayId].orEmpty()
        _currentDay.value = dayId
    }

    private fun FullScheduleInfo.toScheduleItem(
        viewType: ScheduleViewType
    ): ScheduleItem = ScheduleItem(
        lessonName = predmet.name_predmet,
        description = when (viewType) {
            is ByGroup -> prep.fullName
            is ByTeacher -> groups.joinToString { it.group.name_gryp }
            else -> ""
        },
        auditory = audit.name_audit,
        time = rasp.time
    )

}
