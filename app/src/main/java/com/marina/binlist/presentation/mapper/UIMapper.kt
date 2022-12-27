package com.marina.binlist.presentation.mapper

import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.presentation.entity.card.*
import com.marina.binlist.presentation.entity.card.Number

fun CardInfo.toUI(): CardInfoUI {
    return CardInfoUI(
        bin = bin,
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

fun List<CardInfo>.toUI(): List<CardInfoUI> {
    return map {
        it.toUI()
    }
}