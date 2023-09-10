package Stageone.hng.service;

import Stageone.hng.entity.Response;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class GetInfoService {

    public static String capitalizeFirstLetter(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }


    public Response getInfoParam(String slack_name, String track){
        DayOfWeek currentDay = LocalDateTime.now().getDayOfWeek();
        String githubRepoUrl = "https://github.com/meysdays/StageOneHNG";
        String githubFileUrl = "https://github.com/meysdays/StageOneHNG/blob/master/src/main/java/Stageone/hng/HngApplication.java";

        Instant currentInstant = Instant.now();
        Random random = new Random();
        int randomOffset = random.nextInt(241) - 120;
        Instant utcTimeWithAccuracy = currentInstant.plusSeconds(randomOffset);
        String formattedUTCTime = utcTimeWithAccuracy
                .atOffset(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        String current = currentDay.toString().toLowerCase();
        String capitalized = capitalizeFirstLetter(current);

        Response resp = new Response(
                slack_name,
                capitalized,
                formattedUTCTime.toString(),
                track,
                githubFileUrl,
                githubRepoUrl,
                200
        );
        return resp;
    }
}
