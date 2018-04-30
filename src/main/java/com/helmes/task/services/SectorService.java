package com.helmes.task.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmes.task.entities.Sector;
import com.helmes.task.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<Sector> findAllSectors() {
        return sectorRepository.findAll();
    }

    public void addSectorsToDb(String body){
        sectorRepository.deleteAll();

        List<Sector> sectorList = getSectors(body);

        sectorList.forEach(sectorRepository::save);

    }

    private List<Sector> getSectors(String body) {
        ObjectMapper parser = new ObjectMapper();
        byte[] jsonData = body.getBytes();
        List<Sector> sectorList;
        try {
            sectorList = parser.readValue(jsonData, parser.getTypeFactory().constructCollectionType(List.class, Sector.class));
        } catch (IOException e) {
            throw new RuntimeException("Parser failed: " + e.getMessage());
        }
        return sectorList;
    }
}
