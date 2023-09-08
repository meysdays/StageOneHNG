package Stageone.hng.service;

import Stageone.hng.entity.Response;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
public class GetInfoService {

    public Response getInfoParam(String slack_name, String track){
        DayOfWeek currentDay = LocalDateTime.now().getDayOfWeek();

        LocalDateTime utcTime = LocalDateTime.now(ZoneOffset.UTC);
        String githubRepoUrl = "hsaknjdnjkjdsn";
        String githubFileUrl = "hdcuasdhciad";

        Response resp = new Response(
                slack_name,
                currentDay.toString(),
                utcTime.format(DateTimeFormatter.ISO_DATE),
                track,
                githubFileUrl,
                githubRepoUrl,
                200
        );
        return resp;
    }
}
