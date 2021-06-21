package com.leimingting.controller;

import com.leimingting.pojo.BaseDict;
import com.leimingting.pojo.Customer;
import com.leimingting.pojo.Page;
import com.leimingting.pojo.User;
import com.leimingting.service.BaseDictService;
import com.leimingting.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 17:05
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @Resource
    private BaseDictService baseDictService;

    //客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;

    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    //客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;


    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows, String custName, String custSource, String custIndustry, String custLevel, Model model) {
        //条件查询所有用户
        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        model.addAttribute("page", customers);
        //客户来源
        List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        //添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customer";
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(Customer customer, HttpSession session) {
        if (customer.getCust_id() == null) {
            User admin = (User) session.getAttribute("admin");
            customer.setCust_create_id(admin.getId());
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            customer.setCust_createtime(timestamp);
            Integer row = customerService.createCustomer(customer);
            if (row > 0) {
                return "OK";
            } else {
                return "FALL";
            }
        } else {
            Integer row = customerService.updateCustomer(customer);
            if (row > 0) {
                return "OK";
            } else {
                return "FALL";
            }
        }
    }

    @ResponseBody
    @RequestMapping("/getCustomerById")
    public Customer getCustomerById(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @ResponseBody
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(Integer id) {
        Integer row = customerService.deleteCustomer(id);
        if (row > 0) {
            return "OK";
        } else {
            return "FALL";
        }
    }
}
