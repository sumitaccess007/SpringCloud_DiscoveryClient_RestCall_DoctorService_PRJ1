package com.sumitaccess007.connector;

import com.sumitaccess007.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientConnector {
    private RestTemplate restTemplate = new RestTemplate();

    public Patient fetchPatientDetailsByID(String url) {
       return restTemplate.getForObject(url,Patient.class);
    }
}
