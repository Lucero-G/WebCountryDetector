/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import service.CountryDetectorService;
import webservice.CountryDetectorWeb;
import webservice.CountryDetectorWebInterface;

public class WebCountryDetectorGUI extends JFrame {
    private JTextField urlField;
    private JButton detectButton;
    private JLabel resultLabel;
    private CountryDetectorWebInterface service;

    public WebCountryDetectorGUI() {
        initComponents();
        initService();
    }

    private void initComponents() {
        setTitle("Detector de País de Páginas Web");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        urlField = new JTextField();
        detectButton = new JButton("Detectar País");
        resultLabel = new JLabel("Resultado: ");

        add(urlField);
        add(detectButton);
        add(resultLabel);

        detectButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botón presionado");
        if (service != null) {
            String url = urlField.getText();
            System.out.println("Detectando país para la URL: " + url); // Agrega esta línea
            CountryDetectorService concreteService = new CountryDetectorService();
            String country = concreteService.detectCountry(url);
            resultLabel.setText("Resultado: " + country);
        } else {
            resultLabel.setText("Servicio no inicializado.");
        }
    }
});

    }

    private void initService() {
        try {
            URL url = new URL("http://localhost:8080/WebCountryDetector/CountryDetectorWebService?wsdl");
            QName qname = new QName("http://webservice/", "CountryDetectorWebService");
            Service service = Service.create(url, qname);
            this.service = service.getPort(CountryDetectorWebInterface.class);
            System.out.println("Servicio inicializado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al inicializar el servicio: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        /*CountryDetectorService service = new CountryDetectorService();
    System.out.println(service.detectCountry("http://www.example.com"));

        */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WebCountryDetectorGUI().setVisible(true);
            }
        });

    }
}
