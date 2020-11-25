/* 
User: Urmi
Date: 11/25/2020 
Time: 3:03 PM
*/

package com.example.cassandra.springbootcassandrademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @PrimaryKey
    private int id;
    private String name;
}
