package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import co.edu.uniquindio.centroeventos.centroeventos.controller.UsuarioController;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioViewController {

    UsuarioController usuarioControllerService;
    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

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
    private TableView<UsuarioDto> tableUsuarios;

    @FXML
    private TableColumn<UsuarioDto, String> tcCorreo;

    @FXML
    private TableColumn<UsuarioDto, String> tcId;

    @FXML
    private TableColumn<UsuarioDto, String> tcIdReservas;

    @FXML
    private TableColumn<UsuarioDto, String> tcNombre;

    @FXML
    private TextField txtIdReserva;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize(){
        usuarioControllerService = new UsuarioController();
        intiView();
    }

    private void intiView(){
        initDataBinding();
        obtenerUsuarios();
        tableUsuarios.getItems().clear();
        tableUsuarios.setItems(listaUsuariosDto);
        listenerSelection();
    }

    private void initDataBinding(){
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcIdReservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idReservas()));

    }

    private void obtenerUsuarios(){ listaUsuariosDto.addAll(usuarioControllerService.obtenerUsuarios());}

    private void listenerSelection(){
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado){
        if(usuarioSeleccionado != null){
            txtId.setText(usuarioSeleccionado.id());
            txtNombre.setText(usuarioSeleccionado.nombre());
            txtCorreo.setText(usuarioSeleccionado.correo());
            txtIdReserva.setText(usuarioSeleccionado.idReservas());
        }
    }

    @FXML
    void nuevoUsuarioAction(ActionEvent event) {
        txtId.setText("Ingrese el ID");
        txtNombre.setText("Ingrese el nombre");
        txtCorreo.setText("Ingrese el correo");
        txtIdReserva.setText("Ingrese el ID de las reservas");
    }

    @FXML
    void agregarUsuarioAction(ActionEvent event) {
        crearUsuario();

    }

    @FXML
    void eliminarUsuarioAction(ActionEvent event) {
        eliminarUsuario();

    }
    @FXML
    void actualizarUsuarioAction(ActionEvent event) {
        actualizarUsuario();
    }

    private void crearUsuario(){
        UsuarioDto usuarioDto = construirUsuarioDto();

        if(datosValidos(usuarioDto)){
            if(usuarioControllerService.agregarUsuario(usuarioDto)){
                listaUsuariosDto.add(usuarioDto);
                mostrarMensaje("Notificacion Usuario", "Usuario creado", "El usuario se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposUsuario();
            }else{
                mostrarMensaje("Notificación usuario", "Usuario no creado", "El usuario no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación usuario", "Usuario no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarUsuario() {
        boolean usuarioEliminado = false;
        if(usuarioSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al Usuario?")){
                usuarioEliminado = usuarioControllerService.eliminarUsuario(usuarioSeleccionado.id());
                if(usuarioEliminado == true){
                    listaUsuariosDto.remove(usuarioSeleccionado);
                    usuarioSeleccionado = null;
                    tableUsuarios.getSelectionModel().clearSelection();
                    limpiarCamposUsuario();
                    mostrarMensaje("Notificación usuario", "Usuario eliminado", "El usuario se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación usuario", "Usuario no eliminado", "El usuario no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación usuario", "Usuario no seleccionado", "Seleccionado un usuario de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarUsuario(){
        boolean usuarioActualizado = false;

        String idActual = usuarioSeleccionado.id();
        UsuarioDto usuarioDto = construirUsuarioDto();
        if(usuarioSeleccionado != null){
            //3. Validar la información
            if(datosValidos(usuarioSeleccionado)){
                usuarioActualizado = usuarioControllerService.actualizarUsuario(idActual,usuarioDto);
                if(usuarioActualizado){
                    listaUsuariosDto.remove(usuarioSeleccionado);
                    listaUsuariosDto.add(usuarioDto);
                    tableUsuarios.refresh();
                    mostrarMensaje("Notificación usuario", "Usuario actualizado", "El usuario se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposUsuario();
                }else{
                    mostrarMensaje("Notificación usuario", "Usuario no actualizado", "El usuario no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación usuario", "Usuario no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private UsuarioDto construirUsuarioDto() {
        return new UsuarioDto(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtIdReserva.getText());
    }

    private void limpiarCamposUsuario() {
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtIdReserva.setText("");
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        String mensaje = "";
        if (usuarioDto.nombre() == null || usuarioDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n";
        if (usuarioDto.id() == null || usuarioDto.id().equals(""))
            mensaje += "El id es invalido \n";
        if (usuarioDto.correo() == null || usuarioDto.correo().equals(""))
            mensaje += "El correo es invalido \n";
        if (usuarioDto.idReservas() == null || usuarioDto.idReservas().equals(""))
            mensaje += "Los id de las reservas son invalidos \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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
