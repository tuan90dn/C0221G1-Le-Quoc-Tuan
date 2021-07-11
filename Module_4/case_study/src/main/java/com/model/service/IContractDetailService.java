package com.model.service;

import com.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService extends IService<ContractDetail>{
    Page<ContractDetail> findContractDetails(Pageable pageable);
}
