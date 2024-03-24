package co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CentroEvenMapper {

    CentroEvenMapper INSTANCE = Mappers.getMapper(CentroEvenMapper.class);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listsEmpleados);


}

