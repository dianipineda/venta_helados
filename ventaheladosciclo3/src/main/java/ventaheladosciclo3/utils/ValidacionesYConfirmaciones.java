package ventaheladosciclo3.utils;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ValidacionesYConfirmaciones {

    public static void validaExistenciaDeRegistro() throws SQLException {
        JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos", "Error al registrar",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public static void notificacionDeCambiosRealizados() throws SQLException {
        JOptionPane.showMessageDialog(null, "Los cambios se aplicaron correctamente", "Cambios Realizados",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void validaNoExistenciaDeRegistro() throws SQLException {
        JOptionPane.showMessageDialog(null, "El registro no se encuentra en la base de datos",
                "Error de cambios", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void confirmacionDeCambio() throws SQLException {
        JOptionPane.showConfirmDialog(null, "estas seguro de realizar este cambio", "Confirmar cambios",
                JOptionPane.YES_NO_OPTION);
    }
}
