package com.hospital.Controller.Home;


import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private IHomeService homeService;

    @Autowired
    public HomeController(IHomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/api/home/getHomeGeneral")
    public GlobalResponse getHomeInfoGeneral() {
        return homeService.getHomeInfo();
    }
}
