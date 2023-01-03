package com.example.theatre.features.spectacles.api

import com.example.theatre.core.data.common.ItemsListResultModel
import com.example.theatre.core.data.model.performance.PerformanceModel
import com.example.theatre.core.data.model.performance.PerformancePlaceLocationModel
import com.example.theatre.core.data.model.performance.PerformancePlaceModel
import com.example.theatre.network.Constants.AGE_RESTRICTION
import com.example.theatre.network.Constants.BODY_TEXT
import com.example.theatre.network.Constants.CATEGORIES
import com.example.theatre.network.Constants.COMMENTS_COUNT
import com.example.theatre.network.Constants.DATES
import com.example.theatre.network.Constants.DESCRIPTION
import com.example.theatre.network.Constants.EVENT_ID
import com.example.theatre.network.Constants.FAVORITES_COUNT
import com.example.theatre.network.Constants.ID
import com.example.theatre.network.Constants.IMAGES
import com.example.theatre.network.Constants.IS_FREE
import com.example.theatre.network.Constants.LOCATION
import com.example.theatre.network.Constants.PARTICIPANTS
import com.example.theatre.network.Constants.PLACE
import com.example.theatre.network.Constants.PRICE
import com.example.theatre.network.Constants.PUBLICATION_DATE
import com.example.theatre.network.Constants.SHORT_TITLE
import com.example.theatre.network.Constants.SITE_URL
import com.example.theatre.network.Constants.SLUG
import com.example.theatre.network.Constants.TAGLINE
import com.example.theatre.network.Constants.TAGS
import com.example.theatre.network.Constants.TITLE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Performance api - запрос списка постановок
 *
 * @author Marianna Sabanchieva
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