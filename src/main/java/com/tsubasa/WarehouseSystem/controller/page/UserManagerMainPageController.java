package com.tsubasa.WarehouseSystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class UserManagerMainPageController {
    @RequestMapping(value = "/staffManager")
    public String staffManager() {
        return "page/userManager/userTable";
    }

    @RequestMapping(value = "/customerManager")
    public String customerManager() {
        return "page/userManager/customerTable";
    }

    @RequestMapping(value = "/supplierManager")
    public String supplierManager() {
        return "page/userManager/supplierTable";
    }

    @RequestMapping(value = "/newUser")
    public String newUser() {
        return "page/userManager/userForm";
    }

    @RequestMapping(value = "/newCustomer")
    public String newCustomer() {
        return "page/userManager/customerForm";
    }

    @RequestMapping(value = "/newSupplier")
    public String newSupplier() {
        return "page/userManager/supplierForm";
    }
}