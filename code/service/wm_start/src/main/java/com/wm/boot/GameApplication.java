package com.wm.boot;

import com.wm.boot.core.Result;
import com.wm.boot.user.po.UserPo;
import com.wm.boot.utils.IKeyGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wilson
 * @title GameApplication
 * @description 启动类
 * @date 2021.01.30 08:15
 */
@Slf4j
@SpringBootApplication
@EnableR2dbcRepositories
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GameApplication implements CommandLineRunner {

    /**
     * @title main
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.06 17:32
     * @param args
     * @return void
    */
    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
        System.out.println("============启动成功============");
    }
//    @Bean
//    ConnectionFactory connectionFactory() {
//        return MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
//                .host("127.0.0.1")
//                .port(3306)
//                .username("root")
//                .password("123456")
//                .database("wm_game")
//                // 额外的其它非必选参数省略
//                .build());
//    }
    @Resource
    private DatabaseClient db;

    @Bean
    public NamingStrategy namingStrategy() {
        return new NamingStrategy() {
            @Override
            public String getTableName(Class<?> type) {
//				LOGGER.debug("@@@@@@ getTableName {}", type.getSimpleName());
                return type.getSimpleName();
            }

            @Override
            public String getColumnName(RelationalPersistentProperty property) {
//				LOGGER.debug("@@@@@@ getColumnName {}", property.getName());
                return property.getName();
            }
        };
    }

    /**
     * @title GameApplication
     * @description TODO
     * @author wilson
     * @date 2021.02.06 17:32
    */
    @RestController
    public class HomeController{
        @GetMapping(value = "")
        public Result test(){
            return Result.success();
        }
    }

   @Autowired
   IKeyGenerate idUtil;

    @Autowired
            @Qualifier("redisCache")
    ReactiveStringRedisTemplate redis;
    /**
     * @title run
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.06 17:32
     * @param args
     * @return void
    */
    @Override
    public void run(String... args) throws Exception {
        //com.wm.boot
       // Flux.interval(Duration.ofSeconds(1)).subscribe(System.out::println);
redis.opsForValue().get("ddd").subscribe(System.out::println);
        System.out.println(idUtil.newLongID(UserPo.class));

        db.sql("select * from `sys_user`").fetch().all()
                .subscribe(System.out::println);

        System.out.println("============Runing============");
    }


}
