package com.example.demo.service;

import com.example.demo.model.Comuna;
import com.example.demo.model.Region;
import com.example.demo.repository.ComunaRepository;
import com.example.demo.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {
    private final RegionRepository regionRepository;
    private final ComunaRepository comunaRepository;

    public UbicacionService(RegionRepository regionRepository, ComunaRepository comunaRepository) {
        this.regionRepository = regionRepository;
        this.comunaRepository = comunaRepository;
    }

    public List<Region> obtenerRegiones() {
        return regionRepository.findAll();
    }

    public List<Comuna> obtenerComunasPorRegion(Integer idRegion) {
        return comunaRepository.findByRegionIdRegion(idRegion);
    }
}
