package com.sttqa.ping.application;

import com.sttqa.ping.domain.PingResult;
import org.springframework.stereotype.Service;

@Service
public class PingService implements PingUseCase {

    @Override
    public PingResult execute() {
        return PingResult.pong();
    }
}
