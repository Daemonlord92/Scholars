package com.blitmatthew.spring_mvc.service;

import com.blitmatthew.spring_mvc.models.Cybrog;

import java.util.List;

public interface CybrogService {
    Cybrog getCybrogById(Integer id);
    List<Cybrog> getAllCybrogs();
    void addCybrog(Cybrog cybrog);
    void updateCubrog(Cybrog cybrog);
    void deleteCybrog(Integer id);
}
