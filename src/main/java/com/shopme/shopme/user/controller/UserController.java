package com.shopme.shopme.user.controller;

import com.shopme.shopme.formatter.FileUploadUtil;
import com.shopme.shopme.user.UserNotFoundException;
import com.shopme.shopme.user.UserService;
import common.Role;
import common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Set;


@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String usersList(Model model) {
        model.addAttribute("users", service.listAll());
        model.addAttribute("pageTitle", "Users List");
        return "/users/users";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        List<Role> listRoles = service.listRoles();

        user.setEnabled(true);

        model.addAttribute("listRoles", listRoles);

        model.addAttribute("pageTitle", "Create New User");
        return "/users/user_form";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        try {
            User user = service.get(id);
            List<Role> listRoles =service.listRoles();
            Set<Role> roles = user.getRoles();
            System.out.println("======================");
            System.out.println(roles);
            System.out.println(listRoles);



            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User");
            model.addAttribute("listRoles", roles);
            return "users/user_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("sMessage", e.getMessage());
            return "redirect:users";
        }

    }


    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes) throws UserNotFoundException {
       try {
           service.delete(id);
           redirectAttributes.addFlashAttribute("sMessage", "Successfully Deleted");

       }catch (UserNotFoundException e){
           redirectAttributes.addFlashAttribute("sMessage", e.getMessage());
       }
        return "redirect:users";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        var userObject =user;
        if(!multipartFile.isEmpty()){
            String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
            user.setPhotos(fileName);
            User savedUser = service.save(user);
            String uploadDir= "users-photos/"+savedUser.getId();
            //clean-> delete old files in directory before saving file to directory
            FileUploadUtil.clearDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
        }else{
            if(user.getPhotos().isEmpty())user.setPhotos(null);
            service.save(user);
        }
        redirectAttributes.addFlashAttribute("sMessage","User has been saved Successfully");
        return "redirect:/users";
    }


    @GetMapping("/users/{id}/enabled/{status}")
    public String updateUserEnableStatus(@PathVariable("id") Integer id,@PathVariable("status") boolean status, RedirectAttributes redirectAttributes){

        service.updateUserEnabledStatus(id,status);
        String msg="";
        if(status){
            msg="User "+id +" enable status is enabled";
        }else {
            msg="User enable " +id+ " status is disabled";
        }
        redirectAttributes.addFlashAttribute("sMessage",msg);

        return "redirect:/users";
    }
}
