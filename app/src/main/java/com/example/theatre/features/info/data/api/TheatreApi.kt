package com.example.theatre.features.info.data.api

import com.example.theatre.core.data.model.common.ItemsListResultModel
import com.example.theatre.features.Constants.ADDRESS
import com.example.theatre.features.Constants.BODY_TEXT
import com.example.theatre.features.Constants.CATEGORIES
import com.example.theatre.features.Constants.COMMENTS_COUNT
import com.example.theatre.features.Constants.COORDS
import com.example.theatre.features.Constants.DESCRIPTION
import com.example.theatre.features.Constants.FAVORITES_COUNT
import com.example.theatre.features.Constants.FOREIGN_URL
import com.example.theatre.features.Constants.ID
import com.example.theatre.features.Constants.IMAGES
import com.example.theatre.features.Constants.IS_CLOSED
import com.example.theatre.features.Constants.IS_STUB
import com.example.theatre.features.Constants.LOCATION
import com.example.theatre.features.Constants.PHONE
import com.example.theatre.features.Constants.PLACE_ID
import com.example.theatre.features.Constants.SHORT_TITLE
import com.example.theatre.features.Constants.SITE_URL
import com.example.theatre.features.Constants.SLUG
import com.example.theatre.features.Constants.SUBWAY
import com.example.theatre.features.Constants.TAGS
import com.example.theatre.features.Constants.TIMETABLE
import com.example.theatre.features.Constants.TITLE
import com.example.theatre.features.info.data.model.theatre.TheatreLocationModel
import com.example.theatre.features.info.data.model.theatre.TheatreModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Theatre api - запрос списка театров
 *
 * @author Tamerlan Mamukhov
 */

interface TheatreApi {
    @GET(
        """
            places/?fields=$ID,$TITLE,$SHORT_TITLE,$SLUG,$ADDRESS,$LOCATION,$TIMETABLE,$PHONE,
            $IS_STUB,$IMAGES,$DESCRIPTION,$BODY_TEXT,$SITE_URL,$FOREIGN_URL,$COORDS,$SUBWAY,
            $FAVORITES_COUNT,$COMMENTS_COUNT,$IS_CLOSED,$CATEGORIES,$TAGS&categories=theatre&page_size=100
        """
    )
    suspend fun getTheatres(): ItemsListResultModel<TheatreModel>

    @GET("places/{${PLACE_ID}}/")
    suspend fun getTheatreById(@Path(PLACE_ID) id: Int): TheatreModel

    @GET("locations/{$SLUG}/")
    suspend fun getCityName(@Path(SLUG) slug: String): TheatreLocationModel
}