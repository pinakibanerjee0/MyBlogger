package com.pinaki.MyBlogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinaki.MyBlogger.payloads.ApiResponse;
import com.pinaki.MyBlogger.payloads.UserDto;
import com.pinaki.MyBlogger.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "User management APIs")
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// PUT- update user

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}

	// ADMIN
	// DELETE -delete user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

	// GET - user get
	@Operation(summary = "Retrieve a User by Id", description = "Get a User object by specifying its id. The response is User object with id, title, description and published status.", tags = {
			"Users", "get" })
	/*
	 * @ApiResponses({
	 * 
	 * @ApiResponse(responseCode = "200", content = { @Content(schema
	 * = @Schema(implementation = UserDto.class), mediaType = "application/json")
	 * }),
	 * 
	 * @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema())
	 * }),
	 * 
	 * @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema())
	 * }) })
	 */

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// GET - user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
