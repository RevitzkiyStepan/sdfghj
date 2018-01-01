package com.example.arondillqs5328.myfirstkotlinaplication.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by aronDillQs5328 on 17.11.2017.
 */

interface BashImApiService {

    @GET("api/get")
    fun searchQuotes(
            @Query("site") site: String,
            @Query("name") name: String,
            @Query("num") num: Int): io.reactivex.Observable<List<Quote>>

    @GET("api/source")
    fun searchSource(): io.reactivex.Observable<List<SourceOfQuotes>>
}