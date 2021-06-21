package com.leimingting.mapper;

import com.leimingting.pojo.Customer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 16:59
 */
@Repository
public interface CustomerMapper {
    List<Customer> selectCustomerList(Customer customer);

    Integer selectCustomerListCount(Customer customer);

    Integer createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomer(Integer id);
}
