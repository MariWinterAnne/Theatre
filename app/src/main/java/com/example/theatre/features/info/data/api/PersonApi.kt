package com.example.theatre.features.info.data.api

import com.example.theatre.core.data.common.ItemsListResultModel
import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.network.Constants.AGENT_ID
import com.example.theatre.network.Constants.AGENT_TYPE
import com.example.theatre.network.Constants.BODY_TEXT
import com.example.theatre.network.Constants.CTYPE
import com.example.theatre.network.Constants.DESCRIPTION
import com.example.theatre.network.Constants.ID
import com.example.theatre.network.Constants.IMAGES
import com.example.theatre.network.Constants.PARTICIPATIONS
import com.example.theatre.network.Constants.SITE_URL
import com.example.theatre.network.Constants.SLUG
import com.example.theatre.network.Constants.TITLE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Person api - запрос списка актеров
 *
 * @author Marianna Sabanchieva
 */

interface PersonApi {
    @GET(
        """
        agents/?fields=$ID,$TITLE,$SLUG,$DESCRIPTION,$BODY_TEXT,$SITE_URL,$CTYPE,$IMAGES,
        $AGENT_TYPE,$PARTICIPATIONS&category=theatre&agent_type=person&role_id=2&page_size=100
        """
    )
    suspend fun getPerson(): ItemsListResultModel<AgentModel>

    @GET("agents/{${AGENT_ID}}/")
    suspend fun getPersonById(@Path(AGENT_ID) id: Int): AgentModel
}