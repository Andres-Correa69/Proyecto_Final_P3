package co.edu.uniquindio.centroeventos.centroeventos.model;

public enum TipoEstadoReserva {

    PENDIENTE,
    APROBADO,
    RECHAZADA;

    @Override
    public String toString() {
        switch(this) {
            case PENDIENTE:
                return "PENDIENTE";
            case APROBADO:
                return "APROBADO";
            case RECHAZADA:
                return "RECHAZADO";
            default:
                throw new IllegalArgumentException();
        }
    }
}
