package com.timirov.bankingtransactionsapi.searchApi.repository;

import com.timirov.bankingtransactionsapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
