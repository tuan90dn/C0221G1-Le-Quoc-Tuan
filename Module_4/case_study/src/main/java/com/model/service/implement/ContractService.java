package com.model.service.implement;

import com.dto.ContractDto;
import com.dto.IContractDto;
import com.model.entity.Contract;
import com.model.repository.IContractRepository;
import com.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {
        contractRepository.deleteByFlag(id);
    }

    @Override
    public Page<Contract> findByName(String name, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<IContractDto> findContracts(Pageable pageable) {
//        return contractRepository.findContracts(pageable);
//    }

    @Override
    public Page<IContractDto> findListUsingContract(Pageable pageable) {
        return contractRepository.findListUsingContract(pageable);
    }

    @Override
    public Contract findContractByCustomerId(int id) {
        return contractRepository.findContractByCustomerId(id);
    }

    @Override
    public Page<Contract> findContractsByCustomerName(String name, Pageable pageable) {
        return contractRepository.findContractsByCustomerName("%"+name+"%",pageable);
    }
}
