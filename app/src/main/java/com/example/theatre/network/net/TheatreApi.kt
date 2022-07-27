package com.example.theatre.network.net

import com.example.theatre.features.info.data.model.TheatreLocationModel
import com.example.theatre.features.info.data.model.TheatreModel
import com.example.theatre.features.info.data.model.TheatresListResult
import com.example.theatre.network.Constants.ADDRESS
import com.example.theatre.network.Constants.BODY_TEXT
import com.example.theatre.network.Constants.CATEGORIES
import com.example.theatre.network.Constants.COMMENTS_COUNT
import com.example.theatre.network.Constants.COORDS
import com.example.theatre.network.Constants.DESCRIPTION
import com.example.theatre.network.Constants.FAVORITES_COUNT
import com.example.theatre.network.Constants.FOREIGN_URL
import com.example.theatre.network.Constants.ID
import com.example.theatre.network.Constants.IMAGES
import com.example.theatre.network.Constants.IS_CLOSED
import com.example.theatre.network.Constants.IS_STUB
import com.example.theatre.network.Constants.LOCATION
import com.example.theatre.network.Constants.PHONE
import com.example.theatre.network.Constants.PLACE_ID
import com.example.theatre.network.Constants.SHORT_TITLE
import com.example.theatre.network.Constants.SITE_URL
import com.example.theatre.network.Constants.SLUG
import com.example.theatre.network.Constants.SUBWAY
import com.example.theatre.network.Constants.TAGS
import com.example.theatre.network.Constants.TIMETABLE
import com.example.theatre.network.Constants.TITLE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Theatre api - запрос списка театров
 *
 * @author Marianna Sabanchieva
 */

interface TheatreApi {
    @GET(
        """
            places/?fields=$ID,$TITLE,$SHORT_TITLE,$SLUG,$ADDRESS,$LOCATION,$TIMETABLE,$PHONE,
            $IS_STUB,$IMAGES,$DESCRIPTION,$BODY_TEXT,$SITE_URL,$FOREIGN_URL,$COORDS,$SUBWAY,
            $FAVORITES_COUNT,$COMMENTS_COUNT,$IS_CLOSED,$CATEGORIES,$TAGS&categories=theatre&page_size=100
        """
    )
    suspend fun getTheatres(): TheatresListResult

    @GET("places/{${PLACE_ID}}/")
    suspend fun getTheatreById(@Path(PLACE_ID) id: Int): TheatreModel

    @GET("locations/{$SLUG}/")
    suspend fun getCityName(@Path(SLUG) slug: String): TheatreLocationModel
}