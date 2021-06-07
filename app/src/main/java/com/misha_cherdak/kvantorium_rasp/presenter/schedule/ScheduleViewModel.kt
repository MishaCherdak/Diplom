package com.misha_cherdak.kvantorium_rasp.presenter.schedule

import android.app.Application
import android.os.Parcelable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.GroupScheduleInfo
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

    private val _schedule = MutableLiveData<List<GroupScheduleInfo>>()
    val schedule: LiveData<List<GroupScheduleInfo>> get() = _schedule

    init {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                when (viewType) {
                    ScheduleViewType.All -> null
                    is ScheduleViewType.ByGroup -> scheduleDao.getGroupSchedule(viewType.groupId)
                    is ScheduleViewType.ByTeacher -> null
                }
            }
            _schedule.value = data.orEmpty()
        }
    }

}
