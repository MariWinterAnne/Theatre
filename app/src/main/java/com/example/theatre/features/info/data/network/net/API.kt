package com.example.theatre.features.info.data.network.net

import com.example.theatre.features.info.data.model.RequestResultTheatre
import com.example.theatre.features.info.data.model.TheatrePlace
import com.example.theatre.features.info.data.model.GetAgentResult
import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.features.info.data.network.net.Constants.SLUG
import com.example.theatre.features.spectacles.data.model.RequestResult
import com.example.theatre.features.spectacles.data.model.Place
import com.example.theatre.features.spectacles.data.model.Location
import com.example.theatre.features.spectacles.data.model.RoleResult
import com.example.theatre.features.spectacles.data.model.AgentResult
import com.example.theatre.features.spectacles.domain.model.Performance
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("events/?fields=id,publication_date,dates,title,short_title,slug," +
            "place,description,body_text,location,categories,tagline,age_restriction," +
            "price,is_free,images,favorites_count,comments_count,site_url,tags," +
            "participants&categories=theater&order_by=-publication_date&text_format=plain")
    suspend fun getPerformance(): RequestResult

    @GET("events/{event_id}/")
    suspend fun getPerformanceById(@Path("event_id") id: Int): Performance

    @GET("places/{id}/")
    suspend fun getPlaceById(@Path("id") id: Int): Place

    @GET("locations/{$SLUG}/")
    suspend fun getCityName(@Path(SLUG) slug: String): Location

    @GET("agents/?fields=id,title,$SLUG,description,body_text,site_url,ctype,images,agent_type,participations")
    suspend fun getAgent(): AgentResult

    @GET("agent-roles/?fields=id,name,name_plural")
    suspend fun getRoles(): RoleResult


    @GET("places/?fields=id,title,short_title,slug,address,location,timetable,phone,is_stub," +
            "images,description,body_text,site_url,foreign_url,coords,subway,favorites_count," +
            "comments_count,is_closed,categories,tags&categories=theatre&text_format=plain")
    suspend fun getPlaces(): RequestResultTheatre

    @GET("places/{place_id}/")
    suspend fun getTheatreById(@Path("place_id") id: Int): TheatrePlace

    @GET("agents/?fields=id,title,slug,description,body_text,site_url,ctype,images,agent_type," +
            "participations&category=theatre&agent_type=person&role_id=2&text_format=plain")
    suspend fun getPerson(): GetAgentResult

    @GET("agents/{agent_id}/")
    suspend fun getPersonById(@Path("agent_id") id: Int): AgentModel
}