package at.htl.leonding.coronatesttracker.Model

import java.time.LocalDateTime
import java.util.*


data class Report(
    val id: String,
    val dateAndTime: LocalDateTime,
    val isPositive: Boolean,
    val office: String
)
