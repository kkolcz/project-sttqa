package com.sttqa.ping.web;

import com.sttqa.ping.application.PingUseCase;
import com.sttqa.ping.domain.PingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class PingController {
    private final PingUseCase pingUseCase;

    public  PingController(PingUseCase pingUseCase) {
        this.pingUseCase = pingUseCase;
    }

    @GetMapping
    public PingResult ping() {
        return PingResult.pong();
    }

}
