package com.leimingting.service;

import com.leimingting.pojo.Customer;
import com.leimingting.pojo.Page;

import java.util.List;


/**
 * @Author 小T
 * @Date 2021/5/25 17:02
 */
public interface CustomerService {
    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @param custName
     * @param custSource
     * @param custIndustry
     * @param custLevel
     * @return
     */
    Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel);

    /**
     * 查询客户总数
     *
     * @param customer
     * @return
     */
    Integer createCustomer(Customer customer);

    /**
     * 根据id查询客户信息
     *
     * @param id
     * @return
     */
    Customer getCustomerById(Integer id);

    /**
     * 修改客户信息
     *
     * @param customer
     * @return
     */
    Integer updateCustomer(Customer customer);

    /**
     * 删除客户信息
     *
     * @param id
     * @return
     */
    Integer deleteCustomer(Integer id);

}
