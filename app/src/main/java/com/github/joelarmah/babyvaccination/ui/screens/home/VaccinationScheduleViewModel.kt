package com.github.joelarmah.babyvaccination.ui.screens.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity
import com.github.joelarmah.babyvaccination.data.remote.repository.VaccinationScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VaccinationScheduleViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val vaccinationScheduleRepository: VaccinationScheduleRepository
): ViewModel() {

    private val _vaccinationSchedule = MutableStateFlow<List<VaccinationScheduleEntity>>(emptyList())
    val vaccinationSchedule: StateFlow<List<VaccinationScheduleEntity>> = _vaccinationSchedule

    fun loadSchedule(babyDob: String) {
        viewModelScope.launch {
            val schedule = vaccinationScheduleRepository.generateVaccinationSchedule(context, babyDob)
            _vaccinationSchedule.value = schedule
        }
    }

//    fun generateVaccinationSchedule(dob: String, vaccinesData: List<VaccinationScheduleEntity>) {
//        // Launch a coroutine to run this on a background thread
//        viewModelScope.launch {
//            // Call the repository method to generate the vaccination schedule
//            val generatedSchedule = vaccinationScheduleRepository.generateVaccinationSchedule(dob, vaccinesData)
//
//            // Update LiveData with the result
//            _vaccinationSchedule.value = generatedSchedule
//        }
//    }

}