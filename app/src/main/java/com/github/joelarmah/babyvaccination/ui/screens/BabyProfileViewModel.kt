package com.github.joelarmah.babyvaccination.ui.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class BabyProfile(
    var name: String = "",
    var dob: String = "",
    var gender: String = ""
) {
    fun getFirstName(): String {
        return name.split(" ").firstOrNull() ?: ""
    }
}

@HiltViewModel
class BabyProfileViewModel @Inject constructor(

): ViewModel() {

    private val _baby = MutableStateFlow(BabyProfile())
    val baby: StateFlow<BabyProfile> = _baby

    fun setName(name: String) {
        _baby.value = _baby.value.copy(name = name)
    }

    fun setDoB(dob: String) {
        _baby.value = _baby.value.copy(dob = dob)
    }

    fun setGender(gender: String) {
        _baby.value = _baby.value.copy(gender = gender)
    }

    fun clearBabyData() {
        _baby.value = BabyProfile()
    }
}