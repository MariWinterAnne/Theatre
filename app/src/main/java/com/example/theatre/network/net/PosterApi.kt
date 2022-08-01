package com.example.theatre.network.net

import com.example.theatre.core.data.model.PostersListResult
import com.example.theatre.network.Constants.DESCRIPTION
import com.example.theatre.network.Constants.ID
import com.example.theatre.network.Constants.IMAGES
import com.example.theatre.network.Constants.TITLE
import retrofit2.http.GET

/**
 * Интерфейс для получения афиш
 * TODO: доработать
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
interface PosterApi {
    @GET(
        """
            events/?fields=$ID,$TITLE,$DESCRIPTION,$IMAGES&categories=theater&order_by=-publication_date&page_size=10
        """
    )
    suspend fun getPosters(): PostersListResult
}