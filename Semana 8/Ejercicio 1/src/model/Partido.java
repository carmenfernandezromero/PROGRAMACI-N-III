package model;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private boolean jugado;

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado = false;
    }

    public static Partido fromDelimitedString(String linea, String delimitador) {
        String[] trozos = linea.split(delimitador);
        if (trozos.length != 2) {
            return null; // Línea inválida
        }
        return new Partido(trozos[0].trim(), trozos[1].trim());
    }

    public String getResultadoQuiniela() {
        if (!jugado) return "-";
        if (golesLocal > golesVisitante) return "1";
        if (golesLocal < golesVisitante) return "2";
        return "X";
    }

    public void setResultado(int golesLocal, int golesVisitante) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.jugado = true;
    }

    public String getEquipoLocal() { return equipoLocal; }
    public String getEquipoVisitante() { return equipoVisitante; }

    @Override
    public String toString() {
        String marcador = jugado ? (golesLocal + " - " + golesVisitante) : "Sin jugar";
        return String.format("%-20s vs %-20s | %-10s | Signo: %s",
                equipoLocal, equipoVisitante, marcador, getResultadoQuiniela());
    }
}