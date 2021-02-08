package com.wm.boot.game;

import com.wm.boot.core.Result;
import com.wm.boot.game.service.IMatchService;
import com.wm.boot.game.vo.MatchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author wilson
 * @title MatchController
 * @description 比赛控制器
 * @date 2021.02.06 14:24
 */
@RestController
@RequestMapping("/match")
public class GameCongtroller {

    @Autowired
    IMatchService service;

    public Mono<MatchVo> getAll(){
        return  service.getAllMatch();
    }


    @GetMapping(value = "/",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Result<?>> test(){
       return Flux.interval(Duration.ofSeconds(5)).map(i->{
            return Result.success(i);
        });
    }
}
