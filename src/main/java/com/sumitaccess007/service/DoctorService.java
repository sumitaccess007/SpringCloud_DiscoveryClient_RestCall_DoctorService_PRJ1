package com.sumitaccess007.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import com.netflix.discovery.shared.Application;
import com.sumitaccess007.connector.PatientConnector;
import com.sumitaccess007.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    PatientConnector patientConnector;

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;

    public Patient fetchPatientDetailsByID(String url) {
        return patientConnector.fetchPatientDetailsByID(url);
    }

    public Patient doDiscoveryForPatientService(int patientID){
        Application application = eurekaClient.getApplication("SpringCloud_DiscoveryClient_RestCall_PatientService_PRJ1");
        if (application!=null){
            StringBuffer stringBuffer = new StringBuffer("http://");
            InstanceInfo instanceInfo = application.getInstances().get(0);
            stringBuffer.append(instanceInfo.getIPAddr());
            stringBuffer.append(":");
            stringBuffer.append(instanceInfo.getPort());
            stringBuffer.append("/fetch?patientID=");
            stringBuffer.append(patientID);
            return fetchPatientDetailsByID(stringBuffer.toString());
        }else{
            return null;
        }

    }
}
