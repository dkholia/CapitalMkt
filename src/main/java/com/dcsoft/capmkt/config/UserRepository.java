package com.dcsoft.capmkt.config;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Social_User, Long> {

    public Social_User findByEmail(String email);
}
