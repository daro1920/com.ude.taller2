package swing;

import javax.swing.*;
import java.awt.*;

public class MainForm {

    private JComboBox comboBox;

    private JFrame frame;

    private JLabel opciones;
    private JLabel titulo;

    private JPanel panelWest;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JComboBox comboBox1;

    private String[] options = { "Listar Buses",
            "Listar Excursiones entre Precios",
            "Listar Excursiones hacia","Registar Excursiones","Registar Buses","Vender Boleto" };

    public MainForm() {
        initialize();
        setVisible(false);

    }

    private void initialize() {

        comboBox = new JComboBox(options);

        opciones = new JLabel();
        opciones.setText("Opciones");

        titulo =  new JLabel();
        titulo.setText("Excursiones System");

        panelWest = new JPanel(new GridLayout(2,1));
        panelWest.add(opciones);

        panelCenter = new JPanel(new GridLayout(2,1));
        panelCenter.add(comboBox);


        frame = new JFrame("Excursiones del Diablo");
        frame.setLayout(new BorderLayout());
        frame.add(panelCenter,BorderLayout.CENTER);
        frame.add(panelWest,BorderLayout.WEST);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
