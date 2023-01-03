package com.example.theatre.features.poster.data.api

import com.example.theatre.core.data.common.ItemsListResultModel
import com.example.theatre.core.data.model.poster.PosterBriefModel
import com.example.theatre.features.poster.data.model.PosterDetailsModel
import com.example.theatre.network.Constants
import com.example.theatre.network.Constants.AGE_RESTRICTION
import com.example.theatre.network.Constants.BODY_TEXT
import com.example.theatre.network.Constants.DATES
import com.example.theatre.network.Constants.DESCRIPTION
import com.example.theatre.network.Constants.ID
import com.example.theatre.network.Constants.IMAGES
import com.example.theatre.network.Constants.PARTICIPANTS
import com.example.theatre.network.Constants.PRICE
import com.example.theatre.network.Constants.PUBLICATION_DATE
import com.example.theatre.network.Constants.SHORT_TITLE
import com.example.theatre.network.Constants.TITLE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Интерфейс для получения афиш
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
interface PosterApi {
    @GET(
        """
            events/?fields=$ID,$TITLE,$DESCRIPTION,$IMAGES&categories=theater&order_by=-publication_date&page_size=10
        """
    )
    suspend fun getPosters(): ItemsListResultModel<PosterBriefModel>

    @GET(
        "events/{${Constants.EVENT_ID}}/?fields=$ID,$DESCRIPTION,$PUBLICATION_DATE,$IMAGES,$TITLE,$SHORT_TITLE,$PRICE," +
                "$AGE_RESTRICTION,$DATES,$PARTICIPANTS,$BODY_TEXT"
    )
    suspend fun getPosterDetailsById(@Path(Constants.EVENT_ID) id: Int): PosterDetailsModel
}