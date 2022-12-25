package com.marina.binlist.presentation.mapper

import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.presentation.entity.*
import com.marina.binlist.presentation.entity.Number

fun CardInfo.toUI(): CardInfoUI {
    return CardInfoUI(
        bank = Bank(
            name = bankName,
            url = bankUrl,
            phone = bankPhone,
            city = bankCity
        ),
        country = Country(
            letter = countryAlpha2,
            currency = countryCurrency,
            latitude = countryLatitude,
            longitude = countryLongitude,
            name = countryName,
            numeric = countryNumeric
        ),
        number = Number(
            length = numberLength,
            luhn = hasLuhnAlg
        ),
        mainInfo = MainInfo(
            prepaid = prepaid,
            scheme = scheme,
            type = type,
            brand = brand
        )
    )
}