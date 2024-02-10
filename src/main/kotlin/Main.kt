package br.com.iago

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    val json = response.body()
    println(json)

    val gson = Gson()
    val jogoCheapShark = gson.fromJson(json, JogoCheapShark::class.java)
    println(jogoCheapShark)

    val meuJogoUm = Jogo(
        titulo = jogoCheapShark.info.title,
        capa = jogoCheapShark.info.thumb)

    println(meuJogoUm)
}