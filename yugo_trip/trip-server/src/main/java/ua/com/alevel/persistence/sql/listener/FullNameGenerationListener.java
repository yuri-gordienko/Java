package ua.com.alevel.persistence.sql.listener;

import jakarta.persistence.PostLoad;

import org.apache.commons.lang3.StringUtils;

import ua.com.alevel.persistence.sql.entity.user.User;

public class FullNameGenerationListener {

    @PostLoad
    public void generateFullName(User user) {
        if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
            user.setFullName(user.getFirstName() + " " + user.getLastName());
        }
    }
}
