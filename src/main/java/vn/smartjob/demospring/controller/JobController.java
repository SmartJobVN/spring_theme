package vn.smartjob.demospring.controller;

import vn.smartjob.demospring.domain.Job;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {

    @RequestMapping(value = "/form")
    public ModelAndView job() {
        return new ModelAndView("addJob", "job", new Job());
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView processJob(Job job, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("j", job);
        if (result.hasErrors()) {
            modelAndView.setViewName("addJob");
        } else {
            modelAndView.setViewName("resultJob");
        }
        return modelAndView;
    }

}