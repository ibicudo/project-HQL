package com.example.projectHQL.projectHQL.repository;

import com.example.projectHQL.projectHQL.DTO.UserDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<UserDTO, Long> {
    @Query("select user from UserDTO user")
    List<UserDTO> findAllUsers();

    @Modifying
    @Query(value = "insert into users (username, password) values (:username, :password)", nativeQuery = true)
    @Transactional
    void createUser(@Param("username") String username, @Param("password") String password);

    @Query("select user from UserDTO user where user.id like :id")
    UserDTO findUserById(@Param("id") Long id);

    @Query("select user from UserDTO user where user.username like :username")
    List<UserDTO> findByUserNameContains(@Param("username") String username);

    @Modifying
    @Query(value ="update users u set u.password= :password where u.id = :id",nativeQuery = true)
    @Transactional
    void updateUserPassword(@Param("password") String password, @Param("id") Long id);

    @Modifying
    @Query(value = "delete from users u where u.id= :id", nativeQuery = true)
    @Transactional
    void deleteUser(@Param("id") Long id);

}
