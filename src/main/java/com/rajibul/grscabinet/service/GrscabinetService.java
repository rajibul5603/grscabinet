package com.rajibul.grscabinet.service;

import com.rajibul.grscabinet.model.GrscabinetModel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GrscabinetService {
    private List<GrscabinetModel> grsComplains = new ArrayList<GrscabinetModel>();

    @PostConstruct
    public void loadDemoData() {
        grsComplains.add(new GrscabinetModel(1, "Leave application issue",
                "Leave application issue","Abdul Karim", "01716070696"));

        grsComplains.add(new GrscabinetModel(2, "Licence renew issue",
                "Licence renew issue","Najibullah", "01861070695"));

        grsComplains.add(new GrscabinetModel(3, "Leave application issue",
                "Grant misuse issue","Abdullah", "01961070691"));

    }


    // Read All getGrsComplain Data
    public List<GrscabinetModel> getAllGrsComplain() {
        return grsComplains;
    }

    // Read an getGrsComplain Data by ID
    public GrscabinetModel getGrsComplainByID(int id) {
        for ( GrscabinetModel grsComplain : grsComplains) {
            if (grsComplain.getId() ==id){
                return grsComplain;
            }
        }
        return null;
    }

    // Create getGrsComplain
    public void addGrsComplain(GrscabinetModel grsComplain) {
        grsComplains.add(grsComplain);
    }

    // Update an getGrsComplain Data by ID
    public void updateGrsComplain(GrscabinetModel grsComplain) {
        for (int i = 0; i < grsComplains.size(); i++) {
            if (grsComplains.get(i).getId() == (grsComplain.getId())) {
                grsComplains.set(i, grsComplain);
                break;
            }
        }
    }

    // Delete an getGrsComplain Data by ID
    public void deleteGrsComplain(int id) {
        for (int i = 0; i < grsComplains.size(); i++) {
            if (grsComplains.get(i).getId()== id) {
                grsComplains.remove(i);
                break;
            }
        }
    }


}
