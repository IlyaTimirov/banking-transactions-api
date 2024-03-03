package com.timirov.bankingtransactionsapi.searchApi.specification;

import com.timirov.bankingtransactionsapi.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class UserSpecifications {

    public static Specification<User> phoneContains(String phone) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("phones").get("phone"), phone);
    }

    public static Specification<User> emailContains(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("emails").get("email"), email);
    }

    public static Specification<User> fullNameContains(String fullName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%" +  fullName + "%");
    }

    public static Specification<User> dateOfBirthAfter(LocalDate dateOfBirth) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfBirth"), dateOfBirth);
    }
}
