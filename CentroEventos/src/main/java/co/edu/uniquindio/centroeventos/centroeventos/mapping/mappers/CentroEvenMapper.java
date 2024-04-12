package co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CentroEvenMapper {

    CentroEvenMapper INSTANCE = Mappers.getMapper(CentroEvenMapper.class);

    //empleado Dto
    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listsEmpleados);

    //usuario Dto

    @Named("usuarioToUsuarioDto")
    UsuarioDto usurarioToUsuarioDto(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuarioDto(List<Usuario> listsUsuarios);

    //Evento Dto

    @Named("eventoToEventoDto")
    EventoDto eventoToEventoDto(Evento evento);

    Evento eventoDtoToEvento(EventoDto eventoDto);

    @IterableMapping(qualifiedByName = "eventoToEventoDto")
    List<EventoDto> getEventoDto(List<Evento> listsEventos);

    @Named("reservaToReservaDto")
    ReservaDto reservaToReservaDto(Reserva reserva);

    Reserva reservaDtoToReserva(ReservaDto reservaDto);

    @IterableMapping(qualifiedByName = "reservaToReservaDto")
    List<ReservaDto> getReservaDto(List<Reserva> listsReservas);
}

