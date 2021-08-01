package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.UserDao;
import com.hillel.crm.config.dto.UserDto;
import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.rest.UserServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceRestImpl implements UserServiceRest {

    private final UserDao userDao;

    @Override
    @Transactional
    public User create(UserDto userDto) {
        if (!Objects.isNull(userDto.getId())) {
            throw new IllegalArgumentException("Failed to create user. User with such ID already exist.");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userDao.save(user);
    }

    @Override
    public void update(Long id, UserDto userDto) {
        if (!userDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete user. User with such ID doesnt exist.");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setUserID(id);
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete user. User with such ID doesnt exist.");
        }
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) throws RuntimeException {
        User user = userDao.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("не удалось найти Employee с id " + id));
        return user;
    }

    public Page<User> findAllPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
