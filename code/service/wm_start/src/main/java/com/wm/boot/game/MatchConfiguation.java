package com.wm.boot.game;

import com.wm.boot.game.service.IMatchService;
import com.wm.boot.proxy.IProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wilson
 * @title ProxyConfiguation
 * @description 比赛接口配置
 * @date 2021.02.06 08:25
 */
@Configuration
public class MatchConfiguation {


    @Bean
    FactoryBean<IMatchService> matchService(IProxy reqProxy){
        return  new FactoryBean<IMatchService>() {
            @Override
            public IMatchService getObject() throws Exception {
                return (IMatchService) reqProxy.getInstance(this.getObjectType());
            }

            @Override
            public Class<?> getObjectType() {
                return IMatchService.class;
            }
        };
    }
}
