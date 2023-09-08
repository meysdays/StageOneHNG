package Stageone.hng.controller;

import Stageone.hng.entity.Response;
import Stageone.hng.service.GetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInfo {

    @Autowired
    GetInfoService getInfoService;

    @GetMapping("/api")
    public Response getInfo(@RequestParam String slack_name, @RequestParam String track){

        Response res = getInfoService.getInfoParam(slack_name, track);

        return res;
    }
}
