package br.com.challenge.application.city

import br.com.challenge.application.playlist.PlaylistResponse
import br.com.challenge.core.city.CityService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class CityController(
    private val cityService: CityService
) {

    suspend fun playlist(call: ApplicationCall) {

        val cityName = call.parameters["name"] ?: throw Exception()

        val playlists = cityService.playlist(cityName)

        call.respond(HttpStatusCode.OK, PlaylistResponse(playlists))
    }
}