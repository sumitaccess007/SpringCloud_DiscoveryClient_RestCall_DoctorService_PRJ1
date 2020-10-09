package com.sumitaccess007.controller;

import com.sumitaccess007.connector.PatientConnector;
import com.sumitaccess007.model.Patient;
import com.sumitaccess007.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/fetch/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient findPatientDetailsByID(@RequestParam("patientID") int patientID){
        return doctorService.doDiscoveryForPatientService(patientID);

    }
}
