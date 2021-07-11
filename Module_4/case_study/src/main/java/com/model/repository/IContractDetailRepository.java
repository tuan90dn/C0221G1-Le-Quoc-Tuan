package com.model.repository;

import com.model.entity.Contract;
import com.model.entity.ContractDetail;
import com.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Integer> {
    @Query(value = "select * from contract_detail ",nativeQuery = true)
    Page<ContractDetail> findContractDetails(Pageable pageable);
}
