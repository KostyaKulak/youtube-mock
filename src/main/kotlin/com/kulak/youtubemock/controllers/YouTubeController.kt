package com.kulak.youtubemock.controllers

import org.json.JSONObject
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files

@RestController
@RequestMapping("/youtube")
class YouTubeController {
    @GetMapping("/response", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getMockedResponse(): String {
        return JSONObject(
                String(Files.readAllBytes(ClassPathResource("response.json").file.toPath()))
        ).toString()
    }
}