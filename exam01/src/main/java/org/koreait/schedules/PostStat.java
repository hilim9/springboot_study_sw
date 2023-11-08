package org.koreait.schedules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j // log.info, log.error, log.warn
public class PostStat {

    //@Scheduled(cron = "0 0 1 * * *" ) // 새벽 1시 실행 
    //@Scheduled(cron="*/5 * * * * *") // 5초 마다
    //@Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS) // 3초 마다 실행
    //@Scheduled(initialDelay = 3, timeUnit = TimeUnit.SECONDS) // 작업 시작전 3초 대기
    public void process() {
        //System.out.println("게시글 통계 수행");
        log.info("게시글 통계 작업 수행");

    }

}
