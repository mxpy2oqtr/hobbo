package com.healthtracker.repository.user;

import com.healthtracker.entity.user.User;
import com.healthtracker.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
