package com.udacity.project4.locationreminders.data

import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result
import com.udacity.project4.locationreminders.reminderslist.ReminderDataItem

//Use FakeDataSource that acts as a test double to the LocalDataSource
class FakeDataSource(var remindersList: MutableList<ReminderDTO>? = mutableListOf()) : ReminderDataSource {

//    TODO: Create a fake data source to act as a double to the real data source

    private var shouldReturnError = false


    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun getReminders(): Result<List<ReminderDTO>> {

        if (shouldReturnError) {
            return Result.Error(
                "Error getting reminders"
            )
        }
        remindersList?.let { return Result.Success(it) }
        return Result.Error("Reminders not found")
    }

    override suspend fun saveReminder(reminder: ReminderDTO) {
       remindersList?.add(reminder)
    }

    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        remindersList?.firstOrNull { it.id == id }?.let { return Result.Success(it) }
        return Result.Error("Reminder not found")
    }

    override suspend fun deleteAllReminders() {
        remindersList?.clear()
    }

}