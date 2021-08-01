package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.UserDto;
import com.hillel.crm.config.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserServiceRest {
    public User getById(Long id);

    List<User> findAll();

    Page<User> findAllPage(Pageable pageable);

    User create(UserDto userDto);

    public void delete(Long id);

    public void update(Long id, UserDto userDto);
}
