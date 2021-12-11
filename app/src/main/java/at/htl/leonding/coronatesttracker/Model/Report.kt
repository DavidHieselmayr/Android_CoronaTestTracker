package at.htl.leonding.coronatesttracker.Model

import java.util.*


data class Report(val id: String, val dateAndTime: Date, val isPositive: Boolean, val office: String)
