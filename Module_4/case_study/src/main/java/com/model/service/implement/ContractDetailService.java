package com.model.service.implement;

import com.model.entity.ContractDetail;
import com.model.repository.IContractDetailRepository;
import com.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return (List<ContractDetail>) contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<ContractDetail> findByName(String name, Pageable pageable) {
        return null;
    }
    @Override
    public Page<ContractDetail> findContractDetails(Pageable pageable) {
        return contractDetailRepository.findContractDetails(pageable);
    }
}
