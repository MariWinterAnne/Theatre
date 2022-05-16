package com.example.theatre.network.net

import com.example.theatre.features.info.data.model.RequestResultTheatre
import com.example.theatre.features.spectacles.data.model.*
import com.example.theatre.features.spectacles.domain.model.Performance
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("events/?fields=id,publication_date,dates,title,short_title,slug,place,description,body_text,location,categories,tagline,age_restriction,price,is_free,images,favorites_count,comments_count,site_url,tags,participants&categories=theater&expand=id,publication_date,dates,title,short_title,slug,place,description,body_text,location,categories,tagline,age_restriction,price,is_free,images,favorites_count,comments_count,site_url,tags,participants&order_by=-publication_date")
    suspend fun getPerformance(): RequestResult

    @GET("events/{event_id}/")
    suspend fun getPerformanceById(@Path("event_id") id: Int): Performance

    @GET("places/?fields=id,title,short_title,slug,address,location,timetable,phone,is_stub,images,description,body_text,site_url,foreign_url,coords,subway,favorites_count,comments_count,is_closed,categories,tags&categories=theatre&expand=id,title,short_title,slug,address,location,timetable,phone,is_stub,images,description,body_text,site_url,foreign_url,coords,subway,favorites_count,comments_count,is_closed,categories,tags")
    suspend fun getPlaces(): RequestResultTheatre

    @GET("places/{id}/")
    suspend fun getPlaceById(@Path("id") id: Int): Place

    @GET("locations/{slug}/")
    suspend fun getCityName(@Path("slug") slug: String): Location

    @GET("agents/?fields=id,title,slug,description,body_text,site_url,ctype,images,agent_type,participations&expand=id,title,slug,description,body_text,site_url,ctype,images,agent_type,participations")
    suspend fun getAgent(): AgentResult

    @GET("agent-roles/?fields=id,name,name_plural")
    suspend fun getRoles(): RoleResult
}