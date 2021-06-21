package com.leimingting.service.impl;

import com.leimingting.mapper.CustomerMapper;
import com.leimingting.pojo.Customer;
import com.leimingting.pojo.Page;
import com.leimingting.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 17:03
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel) {
        Customer customer = new Customer();
        //判断客户名称
        if (StringUtils.isNotBlank(custName)) {
            customer.setCust_name(custName);
        }
        //判断信息来源
        if (StringUtils.isNotBlank(custSource)) {
            customer.setCust_source(custSource);
        }
        //判断客户所属行业
        if (StringUtils.isNotBlank(custIndustry)) {
            customer.setCust_industry(custIndustry);
        }
        //判断客户级别
        if (StringUtils.isNotBlank(custLevel)) {
            customer.setCust_level(custLevel);
        }
        //当前页
        customer.setStart((page - 1) * rows);
        //每页数
        customer.setRows(rows);
        //查询用户列表
        List<Customer> customers = customerMapper.selectCustomerList(customer);
        //查询客户表总记录数
        Integer count = customerMapper.selectCustomerListCount(customer);
        //创建Page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public Integer createCustomer(Customer customer) {
        return customerMapper.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public Integer deleteCustomer(Integer id) {
        return customerMapper.deleteCustomer(id);
    }

}
