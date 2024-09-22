/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author HP
 */
import javax.ejb.Stateless;
import java.net.URL;

@Stateless
public class CountryDetectorService {
    public String detectCountry(String url) {
            System.out.println("URL recibida: " + url);

    if (url == null || url.isEmpty()) {
        return "Error: URL no válida.";
    }
    try {
        URL urlObj = new URL(url);
        String domain = urlObj.getHost();
        System.out.println("Dominio extraído: " + domain); // Agrega esta línea
        String tld = domain.substring(domain.lastIndexOf('.') + 1);
        System.out.println("TLD extraído: " + tld); // Agrega esta línea

        switch (tld) {
            case "es": return "España";
            case "mx": return "México";
            case "ar": return "Argentina";
            case "co": return "Colombia";
            case "pe": return "Perú";
            case "cl": return "Chile";
            case "com": return "Internacional (posiblemente EE.UU.)";
            default: return "Desconocido";
        }
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}

}