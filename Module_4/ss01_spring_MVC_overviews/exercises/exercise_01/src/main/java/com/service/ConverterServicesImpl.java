package com.service;

import org.springframework.stereotype.Service;

@Service

public class ConverterServicesImpl implements IConverterServices {
    @Override
    public float convert(float a, float b) {
        return a*b;
    }
}
