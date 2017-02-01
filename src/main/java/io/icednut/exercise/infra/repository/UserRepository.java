package io.icednut.exercise.infra.repository;

import io.icednut.exercise.infra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
