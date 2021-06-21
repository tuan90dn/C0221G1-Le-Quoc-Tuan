package com.model.service;

import com.model.entity.Image;
import com.model.repository.img_repository.IImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImgServiceImpl implements IImgService {
    @Autowired
    private IImgRepository imgRepository;
    @Override
    public List<Image> findAll() {
        return imgRepository.findAll();
    }

    @Override
    public void save(Image model) {
        imgRepository.save(model);
    }

    @Override
    public Image findById(int id) {
        return imgRepository.findById(id);
    }
}
