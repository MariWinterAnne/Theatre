package com.example.theatre.features.info.data.api

import com.example.theatre.core.data.model.common.ItemsListResultModel
import com.example.theatre.core.data.model.common.agent.AgentModel
import com.example.theatre.features.Constants.AGENT_ID
import com.example.theatre.features.Constants.AGENT_TYPE
import com.example.theatre.features.Constants.BODY_TEXT
import com.example.theatre.features.Constants.CTYPE
import com.example.theatre.features.Constants.DESCRIPTION
import com.example.theatre.features.Constants.ID
import com.example.theatre.features.Constants.IMAGES
import com.example.theatre.features.Constants.PARTICIPATIONS
import com.example.theatre.features.Constants.SITE_URL
import com.example.theatre.features.Constants.SLUG
import com.example.theatre.features.Constants.TITLE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Person api - запрос списка актеров
 *
 * @author Tamerlan Mamukhov
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