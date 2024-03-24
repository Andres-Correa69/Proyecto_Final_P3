package co.edu.uniquindio.centroeventos.centroeventos;

import co.edu.uniquindio.centroeventos.centroeventos.controller.ModelFactoryController;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;


import java.util.List;

public class MainCentroEven {
    public static void main(String[] arsg){
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        EmpleadoDto empleadoDto = new EmpleadoDto(
                "123456",
                "juan",
                "sdasf"
        );

        if (modelFactoryController.agregarEmpleado(empleadoDto)){
            System.out.println("No existe se agrego correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<EmpleadoDto> empleadoDtoList = modelFactoryController.obtenerEmpleados();
        empleadoDtoList.forEach(System.out::println);
    }
}
