package co.edu.uniquindio.centroeventos.centroeventos;

import co.edu.uniquindio.centroeventos.centroeventos.controller.ModelFactoryController;
import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IModelFactoryService;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.TipoEstadoReserva;


import java.time.LocalDate;
import java.util.List;

public class MainCentroEven {
    public static void main(String[] arsg){
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        EmpleadoDto empleadoDto = new EmpleadoDto(
                "123456",
                "juan",
                "sdasf",
                "12,13,14,15"

        );

        if (modelFactoryController.agregarEmpleado(empleadoDto)){
            System.out.println("No existe se agrego correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<EmpleadoDto> empleadoDtoList = modelFactoryController.obtenerEmpleados();
        empleadoDtoList.forEach(System.out::println);

        //USUARIO

        UsuarioDto usuarioDto = new UsuarioDto(
                "123456",
                "juan",
                "sdasf",
                new Reserva()

        );

        if (modelFactoryController.agregarUsuario(usuarioDto)){
            System.out.println("No existe se agrego correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<UsuarioDto> usuarioDtoList = modelFactoryController.obtenerUsuarios();
        usuarioDtoList.forEach(System.out::println);

        //EVENTO

        EventoDto eventoDto = new EventoDto(
                "123456",
                "juan",
                "sdasf",
                LocalDate.now().toString(), // Obtener la fecha actual
                "1000",
                "12",
                "345"
        );

        if (modelFactoryController.agregarEvento(eventoDto)) {
            System.out.println("El evento se agregó correctamente");
        } else {
            System.out.println("El evento ya existe");
        }

        // Listar eventos
        List<EventoDto> eventoDtoList = modelFactoryController.obtenerEventos();
        eventoDtoList.forEach(System.out::println);

        //RESERVA
        ReservaDto reservaDto = new ReservaDto(
                "35",
                "25",
                "65",
                LocalDate.now().toString(),
                TipoEstadoReserva.PENDIENTE
        );

        if (modelFactoryController.agregarReserva(reservaDto)){
            System.out.println("La reserva se agrego correctamente");
        }else{
            System.out.println("La reserca ya existe");
        }

        //Listar reservas

        List<ReservaDto> reservaDtoList = modelFactoryController.obtenerReservas();
        reservaDtoList.forEach(System.out::println);

    }







}

