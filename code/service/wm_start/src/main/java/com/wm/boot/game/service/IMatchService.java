package com.wm.boot.game.service;

import com.wm.boot.game.vo.MatchVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * @author wilson
 * @title MatchController
 * @description 比赛接口
 * @date 2021.02.06 08:31
 */

@RequestMapping("http://xxxx/")
public interface IMatchService {

    @GetMapping("/match")
    Mono<MatchVo> getAllMatch();

}
