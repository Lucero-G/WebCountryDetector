/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice;

import service.CountryDetectorService;
import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "webservice.CountryDetectorWebInterface")
public class CountryDetectorWeb implements CountryDetectorWebInterface {
    @EJB
    private CountryDetectorService service;

    @Override
    public String detectCountry(String url) {
        return service.detectCountry(url);
    }
}
