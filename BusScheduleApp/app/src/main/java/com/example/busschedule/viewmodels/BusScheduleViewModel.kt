package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import com.example.busschedule.database.database.Schedule
import com.example.busschedule.database.database.ScheduleDao

class BusScheduleViewModel(
    private val scheduleDao: ScheduleDao
) : ViewModel() {
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()
    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}