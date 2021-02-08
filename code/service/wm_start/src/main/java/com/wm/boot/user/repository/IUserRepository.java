package com.wm.boot.user.repository;

import com.wm.boot.user.po.UserPo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wilson
 * @title IUserRepository
 * @description 用户仓储
 * @date 2021.02.06 17:59
 */
@Repository
public interface IUserRepository extends ReactiveCrudRepository<UserPo, Long> {
}
