package com.kaycodes.getip;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class IpController {

    @GetMapping("getip")
    public String getip(HttpServletRequest request){

        return getClientIp(request);

    }

    private String getClientIp(HttpServletRequest response) {
        String clientIps = response.getHeader("X-Forwarded-For");
        log.info("ip address from httpservletrequest = " + clientIps);
        String clientIp;
        if((clientIps == null) || (clientIps.isEmpty())){
            clientIp = response.getRemoteAddr();
            log.info("client ip is null, get remote addr ="+ clientIp);
        }
        else {
            clientIp = clientIps.split(",")[0].trim();
            log.info("client ip is ="+ clientIp);
        }
        return clientIp;
    }


}
