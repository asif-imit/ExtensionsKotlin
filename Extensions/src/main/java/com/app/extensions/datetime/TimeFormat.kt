package com.naxtre.laundryservices.kotlin_extension.datetime

import java.text.SimpleDateFormat
import java.util.*

@Suppress("EnumEntryName")
enum class TimeFormat constructor(val timeFormatter:SimpleDateFormat) {
    hh_mm_a(SimpleDateFormat("hh:mm a", Locale.ROOT)),
    HH_mm(SimpleDateFormat("HH:mm", Locale.ROOT))
}