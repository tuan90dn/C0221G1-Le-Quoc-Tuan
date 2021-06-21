package com.model.service;

import com.model.entity.Image;

import java.util.List;

public interface IImgService {
    List<Image> findAll();
    void save(Image model);
    Image findById(int id);
}
