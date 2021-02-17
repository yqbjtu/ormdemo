package com.yq.ormdemo.domain;


import java.util.Date;
import javax.persistence.*;

import io.ebean.Model;
import lombok.Getter;

@Entity
@Table(name = "po_user")
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String username;

    public String fullname;
    public String mobile;
    public String address;
    public Date createdAt;
    public Date updatedAt;
}