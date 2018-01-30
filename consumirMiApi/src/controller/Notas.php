<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace controller;

/**
 * Description of Alumnos
 *
 * @author DAW
 */
use GuzzleHttp\Client;

class Notas {

    function mostrarNotas() {
        $client = new Client();

        $uri = 'http://localhost:8080/crearApi/rest/alumnos';
        $response = $client->get($uri, $header);
        $json = json_decode($response->getBody());
        return $json;
    }

    function insertarNotas($nota) {
        $client = new Client();

        $uri = 'http://localhost:8080/crearApi/rest/alumnos';
        $response = $client->put($uri, [
            'query' => [
                'alumno' => json_encode($nota)
            ]
        ]);
        return $json;
    }

    function borrarNotas($nota) {
        $client = new Client();

        $uri = 'http://localhost:8080/crearApi/rest/alumnos';
        try {
            $response = $client->delete($uri, [
                'query' => [
                    'alumno' => json_encode($alumno)
                ]
            ]);
        } catch (ClientException $exception) {
            echo $exception->getCode();
            $alumno = json_decode($exception->getResponse()->getBody());
        }
        return $json;
    }

    function updateNotas($nota) {
        $client = new Client();

        $uri = 'http://localhost:8080/baseDatos/rest/notas';
        $response = $client->post($uri, [
            'form_params' => [
                'alumno' => json_encode($alumno)
            ]
        ]);
        return $json;
    }

}