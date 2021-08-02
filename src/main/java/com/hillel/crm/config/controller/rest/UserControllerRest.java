package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.UserDto;
import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.impl.UserServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserControllerRest {

    private static final Logger logger = LoggerFactory.getLogger((UserControllerRest.class));
    private final UserServiceRestImpl userServiceRest;

    @RequestMapping(value = "/get-test", method = RequestMethod.GET)
    public String getSomeString() {
        return "test";
    }

    @RequestMapping(value = "/get-test2", method = RequestMethod.GET)
    public String getSomeString2() {
        return "test2";
    }

    @GetMapping(value = "/get-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getById() {
        final User user = userServiceRest.getById(6L);
        UserDto userDto = new UserDto();
        logger.error("Thats not my fault {} {}", user.getFirstName(), user.getLastName());
        BeanUtils.copyProperties(user, userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getByIdWithPath(@PathVariable long id) {
        final User user = userServiceRest.getById(id);
        UserDto userDto = new UserDto();
        logger.error("Thats not my fault {} {}", user.getFirstName(), user.getLastName());
        BeanUtils.copyProperties(user, userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-id-param", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getByIdWithParam(@RequestParam long id) {
        final User user = userServiceRest.getById(id);
        UserDto userDto = new UserDto();
        logger.error("Thats not my fault {} {}", user.getFirstName(), user.getLastName());
        BeanUtils.copyProperties(user, userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = userServiceRest.findAll();
        List<UserDto> userDtoList = list.stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    BeanUtils.copyProperties(user, userDto);
                    return userDto;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all-pages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserDto>> findAllWithPage(@RequestParam int pageSize,
                                                         @RequestParam int pageNumber) {
        final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        final Page<User> pageUsers = userServiceRest.findAllPage(pageRequest);
        final Page<UserDto> pageUserDto = pageUsers
                .map(user -> {
                    UserDto userDto = new UserDto();
                    BeanUtils.copyProperties(user, userDto);
                    return userDto;
                });
        return new ResponseEntity<>(pageUserDto, HttpStatus.OK);

    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        final User user = userServiceRest.create(userDto);
        userDto.setId(user.getUserID());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userServiceRest.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userServiceRest.update(id, userDto);
    }
}
