package com.shopme.shopme;

import com.shopme.shopme.user.RoleRepository;
import common.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class RoleReposityTest {
    @Autowired
    private RoleRepository rle;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin","manage everything");
        Role saveRole= rle.save(roleAdmin);
        Assert.assertTrue(saveRole.getId()>0);
    }


    @Test
    public void testCreateRestRole(){
        Role salesPerson = new Role("Salesperson","can manage product price,customers,shipping,orders and sales report");
        Role Editor = new Role("Editor","manages categories,brandsmproducts,articles and menus");
        Role Shipper = new Role("Shipper","view products,view orders and updae order status");
        Role Assistant = new Role("Assistant","manages questions and reviews");

        rle.saveAll(List.of(salesPerson, Editor, Shipper, Assistant));

    }



}
