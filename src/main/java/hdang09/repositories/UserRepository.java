/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.repositories;

import hdang09.entites.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    
}
