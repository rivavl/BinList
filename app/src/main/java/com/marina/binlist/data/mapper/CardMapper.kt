package com.marina.binlist.data.mapper

import com.marina.binlist.data.local.entity.CardDB
import com.marina.binlist.data.remote.dto.CardInfoDto
import com.marina.binlist.domain.entity.CardInfo

fun CardInfoDto.toDB(bin: String): CardDB {
    return CardDB(
        id = 0,
        bin = bin,
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

fun CardDB.toDomain(): CardInfo {
    return CardInfo(
        id = id,
        bin = bin,
        numberLength = numberLength,
        hasLuhnAlg = hasLuhnAlg,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryNumeric = countryNumeric,
        countryName = countryName,
        countryAlpha2 = countryAlpha2,
        countryCurrency = countryCurrency,
        countryLatitude = countryLatitude,
        countryLongitude = countryLongitude,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity
    )
}

fun List<CardDB>.toDomain(): List<CardInfo> {
    return map {
        it.toDomain()
    }
}
