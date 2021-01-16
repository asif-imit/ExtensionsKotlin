package com.naxtre.laundryservices.kotlin_extension.datetime

import java.text.SimpleDateFormat
import java.util.*

@Suppress("EnumEntryName")
enum class DateTimeFormats(val formatter:SimpleDateFormat) {
    yyyy_MM_dd_T_HH_mm_ss_SSS_Z(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.ROOT)),
    EEE_MMM_dd_yyyy(SimpleDateFormat("EEE, MMM dd, yyyy", Locale.ROOT)),
    dd_MMM_yyyy(SimpleDateFormat("dd MMM yyyy", Locale.ROOT))
}