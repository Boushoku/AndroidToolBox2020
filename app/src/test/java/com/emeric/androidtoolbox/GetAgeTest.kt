package com.emeric.androidtoolbox

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat


class GetAgeTest {

    fun setup(): SaveActivity {
        val sut = SaveActivity()
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        sut.currentDate = formatter.parse("28/01/2020")
        return sut
    }

    @Test
    fun simpleYear_test() {
        val sut = setup()
        val age = sut.getAge(2000,1,1)
        assertEquals(20, age)
    }

    @Test
    fun simpleMonth_test() {
        val sut = setup()
        val age = sut.getAge(2000, 2, 1)
        assertEquals(19, age)
    }

    @Test
    fun simpleDay_test() {
        val sut = setup()
        val age = sut.getAge(2000, 1, 29)
        assertEquals(19, age)
    }
}