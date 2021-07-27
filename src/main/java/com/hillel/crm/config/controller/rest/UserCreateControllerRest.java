package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.UserDto;
import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.impl.UserServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserCreateControllerRest {

    private final UserServiceRestImpl userServiceRest;

    @RequestMapping(value = "/get-test", method = RequestMethod.GET)
    public String getSomeString() {
        return "test";
    }

    @RequestMapping(value = "/get-test2", method = RequestMethod.GET)
    public String getSomeString2() {
        return "test2";
    }

    @GetMapping(value = "/get-one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getById() {
//        User mike = User.builder()
//                .firstName("Mike")
//                .lastName("Briatko")
//                .build();
        final User user = userServiceRest.getById(6L);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
