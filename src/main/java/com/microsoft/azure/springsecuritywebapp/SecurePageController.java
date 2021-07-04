// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.springsecuritywebapp;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurePageController {

    @RequestMapping("/secure_page")
    public ModelAndView securePage(){
        ModelAndView mav = new ModelAndView("secure_page");

        return mav;
    }

    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }
    
    @RequestMapping("/sample")
    public ModelAndView samplePage() {
    	
    	
        ModelAndView mav = new ModelAndView("sample");
       Object principal= SecurityContextHolder.getContext().getAuthentication().getName();
        String username=null;
       if(principal instanceof UserDetails) {
    	   username=((UserDetails)principal).getUsername();
    	   System.out.println(username);
    	   mav.addObject("username", username);
       }
        return mav;
    }
    
}
