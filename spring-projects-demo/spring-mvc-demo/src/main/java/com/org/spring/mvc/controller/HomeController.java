package com.org.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.spring.mvc.controller.domain.Device;
import com.org.spring.mvc.service.DeviceService;

@Controller
public class HomeController {


    private DeviceService deviceService;

    @Autowired(required = true)
    @Qualifier(value = "deviceService")
    public void setDeviceService(DeviceService ds) {
        this.deviceService = ds;
    }

    @RequestMapping("/signin")
    public String getSignPage() {
        return "signin";
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String listDevices(Model model) {
        model.addAttribute("devices", new Device());
        model.addAttribute("listPersons", this.deviceService.listDevices());
        return "deviceslist";
    }

    @RequestMapping("/showDevices")
    public String getName(HttpServletRequest request, Model model) {

        String userName = request.getParameter("user_name");

        String password = request.getParameter("pwd");

        //	userName = userName.toUpperCase();

        model.addAttribute("device", new Device());
        model.addAttribute("listdevices", this.deviceService.listDevices());
        return "showAllDevices";
    }

    @RequestMapping(value = "/device/add", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("device") Device d) {

        if (true) {
            this.deviceService.addDevice(d);
        } /*
         * else { // existing person, call update this.deviceService.updateDevice(d); }
         */
        return "redirect:/showDevices";

    }

    @RequestMapping("/remove/{ip}")
    public String removeDevice(@PathVariable("ip") String ip) {

        this.deviceService.removeDevice(ip);
        return "redirect:/showDevices";
    }

    @RequestMapping("/edit/{ip}")
    public String editDevice(@PathVariable("ip") String ip, Model model) {
        model.addAttribute("device", this.deviceService.getDeviceByIp(ip));
        model.addAttribute("listdevices", this.deviceService.listDevices());
        return "device";
    }

    @RequestMapping("/postmanRequest")
    public String getPostmanCall(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();

        model.addAttribute("message", "yo" + name);
        return "process";
    }

}
