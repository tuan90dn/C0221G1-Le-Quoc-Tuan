package com.model.repository;

import com.dto.ContractDto;
import com.dto.IContractDto;
import com.model.entity.Contract;
import com.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContractRepository extends PagingAndSortingRepository<Contract,Integer> {
//    @Query(value = "select c.id,start_date,end_date,deposit,total_money,employee_id,customer_id,service_id from contract where is_active=true ",nativeQuery = true)
//    Page<IContractDto> findContracts(Pageable pageable);
//    @Query(value = "select * from contract where datediff(end_date,CURDATE())>0",nativeQuery = true)
    @Query(value = "select c.id,c.start_date as dateStart,c.end_date as dateEnd,c.deposit,c.total_money as totalMoney," +
            "employee.name as employeeName,customer.name as customerName,service.name as serviceName," +
            "group_concat(ats.name) as listServices from contract c " +
            "join contract_detail ct on c.id=ct.contract_id join attach_service ats  " +
            "on ats.id = ct.attach_service_id join customer on customer.id=c.customer_id " +
            "join service on service.id=c.service_id join employee on employee.id=c.employee_id  " +
            "where datediff(c.end_date,CURDATE())>0 group by ct.contract_id",nativeQuery = true)
    Page<IContractDto> findListUsingContract(Pageable pageable);


    @Query(value = "select * from contract where is_active=true and customer_id=:id ",nativeQuery = true)
    Contract findContractByCustomerId(@Param("id") Integer id);
    @Query(value = "select * from contract ct join customer c on ct.customer_id=c.id where c.name like :name",nativeQuery = true)
    Page<Contract> findContractsByCustomerName(@Param("name") String name,Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update contract set is_active=false where id = :id",nativeQuery = true)
    void deleteByFlag(@Param("id") Integer id);
}
