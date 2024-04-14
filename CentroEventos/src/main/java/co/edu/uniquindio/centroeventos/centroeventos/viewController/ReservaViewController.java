package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import co.edu.uniquindio.centroeventos.centroeventos.controller.ReservaController;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;
import co.edu.uniquindio.centroeventos.centroeventos.model.TipoEstadoReserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReservaViewController {

    ReservaController reservaControllerService;
    ObservableList<ReservaDto> listaReservasDto = FXCollections.observableArrayList();
    ReservaDto reservaSeleccionado;

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
    private TableView<ReservaDto> tableReservas;

    @FXML
    private TableColumn<ReservaDto, String> tcEstadoReserva;

    @FXML
    private TableColumn<ReservaDto, String> tcFechaSolicitud;

    @FXML
    private TableColumn<ReservaDto, String> tcId;

    @FXML
    private TableColumn<ReservaDto, String> tcIdEvento;

    @FXML
    private TableColumn<ReservaDto, String> tcIdUsuario;

    @FXML
    private MenuItem txtAprobado;

    @FXML
    private DatePicker txtFechaSolucitud;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtIdEvento;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private MenuItem txtPendiente;

    @FXML
    private MenuItem txtRechazado;

    @FXML
    private MenuButton txtEstadoReserva;


    @FXML
    void initialize(){
        reservaControllerService = new ReservaController();
        intiView();

    }

    private void intiView(){
        initDatabindig();
        obtenerReservas();
        tableReservas.getItems().clear();
        tableReservas.setItems(listaReservasDto);
        listenerSelection();

    }

    private void initDatabindig(){

        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcIdUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().usuario().getId()));
        tcIdEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().evento().getId()));
        tcFechaSolicitud.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaSolicitud()));
        tcEstadoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().estadoReserva().toString()));



    }

    private void obtenerReservas(){ listaReservasDto.addAll(reservaControllerService.obtenerReserva());}

    private void listenerSelection(){
        tableReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionado = newSelection;
            mostrarInformacionReserva(reservaSeleccionado);
        });
    }

    private void mostrarInformacionReserva(ReservaDto reservaSeleccionado){
        if(reservaSeleccionado != null){
            txtId.setText(reservaSeleccionado.id());
            txtIdUsuario.setText(reservaSeleccionado.usuario().getId());
            txtIdEvento.setText(reservaSeleccionado.evento().getId());
            txtFechaSolucitud.setValue(LocalDate.parse(reservaSeleccionado.fechaSolicitud()));
            txtEstadoReserva.setText(String.valueOf(reservaSeleccionado.estadoReserva()));
        }
    }


    @FXML
    void asignarAprobado(ActionEvent event) {
        if(txtAprobado.getText().equalsIgnoreCase("APROBADO")){
            txtEstadoReserva.setText("APROBADO");
        }

    }

    @FXML
    void asignarPendiente(ActionEvent event) {
        if(txtPendiente.getText().equalsIgnoreCase("PENDIENTE")){
            txtEstadoReserva.setText("PENDIENTE");
        }

    }

    @FXML
    void asignarRechazado(ActionEvent event) {
        if (txtRechazado.getText().equalsIgnoreCase("RECHAZADA")){
            txtEstadoReserva.setText("RECHAZADA");
        }

    }

    @FXML
    void nuevoReservaAction(ActionEvent event) {
        txtId.setText("Ingrese el ID");
        txtIdUsuario.setText("Ingrese el ID del usuario");
        txtIdEvento.setText("Ingrese el ID del evento");
        txtFechaSolucitud.setValue(null);
        txtEstadoReserva.setText("Seleccione");

    }

    @FXML
    void agregarReservaAction(ActionEvent event) {
        crearReserva();

    }


    @FXML
    void eliminarReservaAction(ActionEvent event) {
        eliminarReserva();

    }
    @FXML
    void actualizarReservaAction(ActionEvent event) {
        actualizarReserva();
    }

    private void crearReserva(){
        ReservaDto reservaDto = construirReservaDto();

        if(datosValidos(reservaDto)){
            if(reservaControllerService.agregarReserva(reservaDto)){
                listaReservasDto.add(reservaDto);
                mostrarMensaje("Notificacion Reserva", "Reserva creado", "El Reserva se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposReserva();
            }else{
                mostrarMensaje("Notificación Reserva", "Reserva no creado", "El Reserva no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Reserva", "Reserva no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }

    private void eliminarReserva(){
        boolean ReservaEliminado = false;
        if(reservaSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar la reserva?")){
                ReservaEliminado = reservaControllerService.eliminarReserva(reservaSeleccionado.id());
                if(ReservaEliminado == true){
                    listaReservasDto.remove(reservaSeleccionado);
                    reservaSeleccionado = null;
                    tableReservas.getSelectionModel().clearSelection();
                    limpiarCamposReserva();
                    mostrarMensaje("Notificación Reserva", "Reserva eliminado", "La Reserva se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación Reserva", "Reserva no eliminado", "La Reserva no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación Reserva", "Reserva no seleccionado", "Seleccionado una reserva de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarReserva(){
        boolean reservaActualizada = false;

        String idActual = reservaSeleccionado.id();
        ReservaDto reservaDto = construirReservaDto();
        if(reservaSeleccionado != null){
            //3. Validar la información
            if(datosValidos(reservaSeleccionado)){
                reservaActualizada = reservaControllerService.actualizarReserva(idActual,reservaDto);
                if(reservaActualizada){
                    listaReservasDto.remove(reservaSeleccionado);
                    listaReservasDto.add(reservaDto);
                    tableReservas.refresh();
                    mostrarMensaje("Notificación Reserva", "Reserva actualizado", "El reserva se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposReserva();
                }else{
                    mostrarMensaje("Notificación Reserva", "Reserva no actualizado", "El reserva no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación reserva", "Reserva no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private ReservaDto construirReservaDto() {
        String fecha = ""; // Inicializar la fecha como una cadena vacía
        LocalDate fechaSeleccionada = txtFechaSolucitud.getValue(); // Obtener la fecha seleccionada del componente txtFecha
        if (fechaSeleccionada != null) {
            fecha = fechaSeleccionada.toString(); // Convertir la fecha seleccionada a una cadena
        }
        TipoEstadoReserva estadoReserva;
        if(txtEstadoReserva.getText().equalsIgnoreCase("pendiente")){
           estadoReserva = TipoEstadoReserva.valueOf(txtPendiente.getText());
        } else if (txtEstadoReserva.getText().equalsIgnoreCase("aprobado")) {
            estadoReserva = TipoEstadoReserva.valueOf(txtAprobado.getText());

        }else if (txtEstadoReserva.getText().equalsIgnoreCase("rechazada")){
            estadoReserva = TipoEstadoReserva.valueOf(txtRechazado.getText());

        }else {
            estadoReserva = TipoEstadoReserva.valueOf(txtEstadoReserva.getText());


        }

        String usuarioId = txtIdUsuario.getText();
        Usuario usuario1 = new Usuario(usuarioId);

        String eventoId = txtIdUsuario.getText();
        Evento evento1 = new Evento(eventoId);
        return new ReservaDto(
                txtId.getText(),
                usuario1,
                evento1,
                fecha,
                estadoReserva
                );
    }

    private void limpiarCamposReserva(){
        txtId.setText("");
        txtIdUsuario.setText("");
        txtIdEvento.setText("");
        txtFechaSolucitud.setValue(null);
        txtEstadoReserva.setText("Seleccione");
    }

    private boolean datosValidos(ReservaDto reservaDto) {
        String mensaje = "";
        if (reservaDto.id() == null || reservaDto.id().equals(""))
            mensaje += "El ID es invalido \n";
        if (reservaDto.usuario().getId() == null || reservaDto.usuario().getId().equals(""))
            mensaje += "El ID de usuario es invalido \n";
        if (reservaDto.evento().getId() == null || reservaDto.evento().getId().equals(""))
            mensaje += "El id del evento es invalido \n";
        if (reservaDto.fechaSolicitud() == null || reservaDto.fechaSolicitud().equals(""))
            mensaje += "la fecha es invalida \n";
       if (reservaDto.estadoReserva() == null || reservaDto.estadoReserva().equals(""))
           mensaje += "el estado de la reserva es invalido \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación Reserva","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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
