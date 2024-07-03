package com.blitmatthew.spring_mvc.service;

import com.blitmatthew.spring_mvc.models.Cybrog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class CybrogServiceImpl implements CybrogService{
    private List<Cybrog> cybrogs;

    public CybrogServiceImpl() {
        Cybrog cybrog = Cybrog.builder()
                .id(1)
                .name("Cybermen")
                .alloy("Cyberium")
                .serialNumber("hf9832f438fgo378fg2087f2f393t4")
                .noOfWeapons(5)
                .noOfCpus(320000)
                .storage(320000)
                .build();
        Cybrog cybrog1 = Cybrog.builder()
                .id(2)
                .name("Dalek Khan")
                .alloy("Dalekum")
                .serialNumber("fh237fow8yg2487g348tg03784y278")
                .noOfWeapons(5)
                .noOfCpus(600000)
                .storage(457357345)
                .build();
        this.cybrogs = new LinkedList<>();
        this.cybrogs.addAll(List.of(cybrog, cybrog1));
    }

    @Override
    public Cybrog getCybrogById(Integer id) {
        return cybrogs.stream().filter(cy -> cy.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<Cybrog> getAllCybrogs() {
        return cybrogs;
    }

    @Override
    public void addCybrog(Cybrog cybrog) {
        cybrog.setId(this.cybrogs.size()+1);
        cybrogs.add(cybrog);
    }

    @Override
    public void updateCubrog(Cybrog cybrog) {
        log.info(cybrog.toString());
        for (int i = 0; i < cybrogs.size(); i++) {
            if(cybrogs.get(i).getId().equals(cybrog.getId())){
                cybrogs.set(i, cybrog);
                return;
            }
        }
    }

    @Override
    public void deleteCybrog(Integer id) {
        for (int i = 0; i < cybrogs.size(); i++) {
            if(cybrogs.get(i).getId().equals(id)){
                cybrogs.remove(i);
                return;
            }
        }
    }
}
