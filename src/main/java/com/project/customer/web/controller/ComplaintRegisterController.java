package com.project.customer.web.controller;

import com.project.customer.business.bean.ComplaintBean;
import com.project.customer.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ComplaintRegisterController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/loadComplaintForm.html")
    public ModelAndView loadComplaintForm(){
        ModelAndView modelAndView = new ModelAndView();
        ComplaintBean complaintBean = new ComplaintBean();

        modelAndView.addObject("complaintBean", complaintBean);
        modelAndView.setViewName("ComplaintPage");
        return modelAndView;
    }

    @RequestMapping(value = "/processComplaintForm.html", method = RequestMethod.POST)
    public ModelAndView processComplaintForm(@ModelAttribute("complainBean") @Valid ComplaintBean bean, BindingResult result) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("ComplaintPage");
        } else{
            complaintService.registerComplaintDetails(bean);
            modelAndView.setViewName("Success");
            modelAndView.addObject("message", "Hi " + bean.getCustomerName() + " your complaint is successfully registered.");
        }
        return modelAndView;
    }

    @ModelAttribute("types")
    public Map<Integer,String> getAllComplaintTypes(){
        return complaintService.getAllComplaintTypes();
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleAllException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("GeneralizedExceptionHandlerPage");
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}