package co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CentroEventosMapper {

    CentroEventosMapper INSTANCE = Mappers.getMapper(CentroEventosMapper.class);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listsEmpleados);

//    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
//    @IterableMapping(qualifiedByName = "usuarioTousuarioDto")
//

}

