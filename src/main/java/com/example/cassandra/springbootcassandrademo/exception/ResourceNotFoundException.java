/* 
User: Urmi
Date: 11/25/2020 
Time: 3:11 PM
*/

package com.example.cassandra.springbootcassandrademo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
