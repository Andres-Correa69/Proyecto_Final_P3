package co.edu.uniquindio.centroeventos.centroeventos.viewController;
import co.edu.uniquindio.centroeventos.centroeventos.controller.EmpleadoController;
import co.edu.uniquindio.centroeventos.centroeventos.controller.EventoController;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class EventoViewController {

    EventoController eventoControllerService;
    ObservableList<EventoDto> listaEventosDto = FXCollections.observableArrayList();

    EventoDto eventoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<EventoDto> tableEventos;

    @FXML
    private TableColumn<EventoDto, String> tcCapacidadMax;

    @FXML
    private TableColumn<EventoDto, String> tcDescripcion;

    @FXML
    private TableColumn<EventoDto, String> tcEmpleadoEncargado;

    @FXML
    private TableColumn<EventoDto, String> tcFecha;

    @FXML
    private TableColumn<EventoDto, String> tcId;

    @FXML
    private TableColumn<EventoDto, String> tcIdReservas;

    @FXML
    private TableColumn<EventoDto, String> tcNombre;

    @FXML
    private TextField txtCapacidadMax;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtEmpleadoEncargado;

    @FXML
    private DatePicker txtFecha;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtIdReserva;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize(){
        eventoControllerService = new EventoController();
        intiView();
    }

    private void intiView(){
        initDataBinding();
        obtenerEventos();
        tableEventos.getItems().clear();
        tableEventos.setItems(listaEventosDto);
        listenerSelection();
    }

    private void initDataBinding(){
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tcCapacidadMax.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().capacidadMax()));
        tcEmpleadoEncargado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().empleado().getId()));
        tcIdReservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().reserva().getId()));
    }

    private void obtenerEventos(){ listaEventosDto.addAll(eventoControllerService.obtenerEventos());}

    private void listenerSelection(){
        tableEventos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            eventoSeleccionado = newSelection;
            mostrarInformacionEvento(eventoSeleccionado);
        });
    }

    private void mostrarInformacionEvento(EventoDto eventoSeleccionado){
        if(eventoSeleccionado != null){
            txtId.setText(eventoSeleccionado.id());
            txtNombre.setText(eventoSeleccionado.nombre());
            txtDescripcion.setText(eventoSeleccionado.descripcion());
            txtFecha.setValue(LocalDate.parse(eventoSeleccionado.fecha()));
            txtCapacidadMax.setText(eventoSeleccionado.capacidadMax());
            txtEmpleadoEncargado.setText(eventoSeleccionado.empleado().getId());
            txtIdReserva.setText(eventoSeleccionado.reserva().getId());

        }
    }


    @FXML
    void nuevoEventoAction(ActionEvent event) {
        txtId.setText("Ingrese el ID");
        txtNombre.setText("Ingrese el nombre");
        txtDescripcion.setText("Ingrese la Descripcion");
        txtFecha.setValue(null);
        txtCapacidadMax.setText("Ingrese la capacidad");
        txtEmpleadoEncargado.setText("Ingrese el ID del empleado encargado");
        txtIdReserva.setText("Ingrese el ID de la reserva");
    }


    @FXML
    void agregarEventoAction(ActionEvent event) {
        crearEvento();

    }

    @FXML
    void eliminarEventoAction(ActionEvent event) {
        eliminarEvento();
    }

    @FXML
    void actualizarEventoAction(ActionEvent event) {
        actualizarEvento();

    }

    private void crearEvento(){
        EventoDto eventoDto = construirEventoDto();

        if(datosValidos(eventoDto)){
            if(eventoControllerService.agregarEvento(eventoDto)){
                listaEventosDto.add(eventoDto);
                mostrarMensaje("Notificacion Evento", "Evento creado", "El Evento se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEvento();
            }else{
                mostrarMensaje("Notificación Evento", "Evento no creado", "El Evento no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarEvento() {
        boolean eventoEliminado = false;
        if(eventoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar el evento?")){
                eventoEliminado = eventoControllerService.eliminarEvento(eventoSeleccionado.id());
                if(eventoEliminado == true){
                    listaEventosDto.remove(eventoSeleccionado);
                    eventoSeleccionado = null;
                    tableEventos.getSelectionModel().clearSelection();
                    limpiarCamposEvento();
                    mostrarMensaje("Notificación evento", "Evento eliminado", "El evento se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación evento", "Evento no eliminado", "El Evento no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación evento", "Evento no seleccionado", "Seleccionado un Evento de la lista", Alert.AlertType.WARNING);
        }
    }


    private void actualizarEvento(){
        boolean eventoActualizado = false;

        String idActual = eventoSeleccionado.id();
        EventoDto eventoDto = construirEventoDto();
        if(eventoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(eventoSeleccionado)){
                eventoActualizado = eventoControllerService.actualizarEvento(idActual,eventoDto);
                if(eventoActualizado){
                    listaEventosDto.remove(eventoSeleccionado);
                    listaEventosDto.add(eventoDto);
                    tableEventos.refresh();
                    mostrarMensaje("Notificación evento", "Evento actualizado", "El evento se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEvento();
                }else{
                    mostrarMensaje("Notificación evento", "Evento no actualizado", "El evento no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private EventoDto construirEventoDto() {
        String fecha = ""; // Inicializar la fecha como una cadena vacía
        LocalDate fechaSeleccionada = txtFecha.getValue(); // Obtener la fecha seleccionada del componente txtFecha
        if (fechaSeleccionada != null) {
            fecha = fechaSeleccionada.toString(); // Convertir la fecha seleccionada a una cadena
        }

        String empleadoId = txtEmpleadoEncargado.getText();
        Empleado empleado1 = new Empleado(empleadoId);

        String reservaId = txtIdReserva.getId();
        Reserva reserva1 = new Reserva(reservaId);
        return new EventoDto(
                txtId.getText(),
                txtNombre.getText(),
                txtDescripcion.getText(),
                fecha,
                txtCapacidadMax.getText(),
                empleado1,
                reserva1);

    }

    private void limpiarCamposEvento() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFecha.setValue(null);
        txtCapacidadMax.setText("");
        txtEmpleadoEncargado.setText("");
        txtIdReserva.setText("");
    }

    private boolean datosValidos(EventoDto eventoDto) {
        String mensaje = "";
        if (eventoDto.nombre() == null || eventoDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n";
        if (eventoDto.id() == null || eventoDto.id().equals(""))
            mensaje += "El id es invalido \n";
        if (eventoDto.descripcion() == null || eventoDto.descripcion().equals(""))
            mensaje += "El correo es invalido \n";
        if (eventoDto.fecha() == null || eventoDto.fecha().equals(""))
            mensaje += "la fecha es invalida \n";
        if (eventoDto.capacidadMax() == null || eventoDto.capacidadMax().equals(""))
            mensaje += "la capacidad maxima es invalida \n";
        if (eventoDto.empleado().getId() == null || eventoDto.empleado().getId().equals(""))
            mensaje += "los ID de los empleados son ivalidos \n";
        if (eventoDto.reserva().getId() == null || eventoDto.reserva().getId().equals(""))
            mensaje += "los ID de las reservas son invalidos \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación Evento","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
