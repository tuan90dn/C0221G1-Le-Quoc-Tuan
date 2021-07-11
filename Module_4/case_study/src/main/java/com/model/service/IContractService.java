package com.model.service;

import com.dto.ContractDto;
import com.dto.IContractDto;
import com.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IContractService extends IService<Contract>{
//    Page<IContractDto> findContracts(Pageable pageable);
    Page<IContractDto> findListUsingContract(Pageable pageable);
    Contract findContractByCustomerId(int id);
    Page<Contract> findContractsByCustomerName(String name,Pageable pageable);
}
