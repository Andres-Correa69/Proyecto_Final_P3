package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;

import java.util.ArrayList;

public record EmpleadoDto(

        String id,
        String nombre,

        String correo,

        Evento evento)
        {



        }
