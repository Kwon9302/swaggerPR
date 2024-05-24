package com.jone.restfulservice.controller;

import com.jone.restfulservice.bean.User;
import com.jone.restfulservice.dao.UserDaoService;
import com.jone.restfulservice.exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@Tag(name = "user-conttttttotoot",description = "일반 사용자 서비스임니돠")
public class UserController {

    private final UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }


    @Operation(summary = "사용자 정보 조회 API",description = "사용자 ID를 이용하여 정보 상세 조회")
    @ApiResponses({
            @ApiResponse(responseCode ="200", description = "okok"),
            @ApiResponse(responseCode ="400", description = "bad request!!!"),
            @ApiResponse(responseCode ="404", description = "user not found!!!!!"),
            @ApiResponse(responseCode ="500", description = "Internal server err"),
    })
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(
            @Parameter(description = "사용자ID", required = true,example = "1") @PathVariable int id) {
        User user =service.findOne(id);

        if (user == null) { // 데이터가 null이라면
            throw new UserNotFoundException(String.format("ID[%s not found", id)); //
        }

        EntityModel entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linTo.withRel("all-users")); //all-users -> http://localhost:8082/users

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        User deleteUser = service.deleteById(id);

        if (deleteUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return ResponseEntity.noContent().build();
    }
}
