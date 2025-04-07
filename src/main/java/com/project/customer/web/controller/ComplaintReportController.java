package com.project.customer.web.controller;

import com.project.customer.business.bean.ComplaintBean;
import com.project.customer.business.bean.DateRangeBean;
import com.project.customer.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ComplaintReportController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/loadComplaintReport.html")
    public ModelAndView loadComplaintReport(){
        return new ModelAndView("ComplaintReport", "dateRangeBean", new DateRangeBean());
    }

    @RequestMapping(value = "/getDetails.html", method = RequestMethod.POST)
    public ModelAndView getComplaintDetailsByDate(@ModelAttribute("dateRangeBean") DateRangeBean dateRangeBean){
        ModelAndView modelAndView = new ModelAndView();
        List<ComplaintBean> complaints = complaintService.getComplaintDetailsByDate(dateRangeBean.getFromDate(), dateRangeBean.getToDate());
        modelAndView.setViewName("ShowComplaintDetails");
        modelAndView.addObject("complaints", complaints);
        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleAllExceptions(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("GeneralizedExceptionHandlerPage");
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
