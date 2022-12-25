package com.marina.binlist.data.mapper

import com.marina.binlist.data.remote.dto.CardInfoDto
import com.marina.binlist.domain.entity.CardInfo

fun CardInfoDto.toDomain(): CardInfo {
    return CardInfo(
        numberLength = number.length,
        hasLuhnAlg = number.luhn,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryNumeric = country?.numeric,
        countryName = country?.name,
        countryAlpha2 = country?.letter,
        countryCurrency = country?.currency,
        countryLatitude = country?.latitude,
        countryLongitude = country?.longitude,
        bankName = bank?.name,
        bankUrl = bank?.url,
        bankPhone = bank?.phone,
        bankCity = bank?.city
    )
}