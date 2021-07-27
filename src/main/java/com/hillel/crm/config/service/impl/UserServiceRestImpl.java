package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.UserDao;
import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.rest.UserServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceRestImpl implements UserServiceRest {

    private final UserDao userDao;

    @Override
    public User getById(Long id) throws RuntimeException {
        User user = userDao.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("не удалось найти Employee с id " + id))
                ;
        return user;
    }
}
