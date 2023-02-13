package com.example.theatre.features.spectacles.data.api

import com.example.theatre.core.data.model.common.ItemsListResultModel
import com.example.theatre.features.Constants.AGE_RESTRICTION
import com.example.theatre.features.Constants.BODY_TEXT
import com.example.theatre.features.Constants.CATEGORIES
import com.example.theatre.features.Constants.COMMENTS_COUNT
import com.example.theatre.features.Constants.DATES
import com.example.theatre.features.Constants.DESCRIPTION
import com.example.theatre.features.Constants.EVENT_ID
import com.example.theatre.features.Constants.FAVORITES_COUNT
import com.example.theatre.features.Constants.ID
import com.example.theatre.features.Constants.IMAGES
import com.example.theatre.features.Constants.IS_FREE
import com.example.theatre.features.Constants.LOCATION
import com.example.theatre.features.Constants.PARTICIPANTS
import com.example.theatre.features.Constants.PLACE
import com.example.theatre.features.Constants.PRICE
import com.example.theatre.features.Constants.PUBLICATION_DATE
import com.example.theatre.features.Constants.SHORT_TITLE
import com.example.theatre.features.Constants.SITE_URL
import com.example.theatre.features.Constants.SLUG
import com.example.theatre.features.Constants.TAGLINE
import com.example.theatre.features.Constants.TAGS
import com.example.theatre.features.Constants.TITLE
import com.example.theatre.features.spectacles.data.api.model.PerformanceModel
import com.example.theatre.features.spectacles.data.api.model.PerformancePlaceLocationModel
import com.example.theatre.features.spectacles.data.api.model.PerformancePlaceModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Performance api - запрос списка постановок
 *
 * @author Tamerlan Mamukhov
 */

interface PerformanceApi {
    @GET(
        """
        events/?fields=$ID,$PUBLICATION_DATE,$DATES,$TITLE,$SHORT_TITLE,$SLUG,$PLACE,$DESCRIPTION,
        $BODY_TEXT,$LOCATION,$CATEGORIES,$TAGLINE,$AGE_RESTRICTION,$PRICE,$IS_FREE,$IMAGES,
        $FAVORITES_COUNT,$COMMENTS_COUNT,$SITE_URL,$TAGS,
        $PARTICIPANTS&categories=theater&order_by=-publication_date&page_size=100
        """
    )
    suspend fun getPerformance(): ItemsListResultModel<PerformanceModel>

    @GET("events/{$EVENT_ID}/")
    suspend fun getPerformanceById(@Path(EVENT_ID) id: Int): PerformanceModel

    @GET("places/{$ID}/")
    suspend fun getPlaceById(@Path(ID) id: Int): PerformancePlaceModel

    @GET("locations/{$SLUG}/")
    suspend fun getCityName(@Path(SLUG) slug: String): PerformancePlaceLocationModel
}