package com.purpleeagle.fplpredictor.model.network

import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.BootStrapModel
import com.purpleeagle.fplpredictor.model.models.elementsummary.ElementSummary
import com.purpleeagle.fplpredictor.model.models.fixtures.FixtureApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private val Ktor = HttpClient(OkHttp){
    expectSuccess = true

    defaultRequest {
        url("https://fantasy.premierleague.com/api/")
    }

    install(ContentNegotiation){
        json(Json { ignoreUnknownKeys = true })
    }
}

class FplApiService{
    suspend fun getBootStrap(): Result<BootStrapModel> = runCatching{
        Ktor.get("bootstrap-static/").body()
    }

    suspend fun getElementSummaryById(id: Int): Result<ElementSummary> = runCatching {
        Ktor.get("element-summary/$id/").body()
    }

    suspend fun getFixtures(): Result<List<FixtureApi>> = runCatching {
        Ktor.get("fixtures/").body()
    }
}
