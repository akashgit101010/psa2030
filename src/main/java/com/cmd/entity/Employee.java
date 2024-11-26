package com.cmd.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email_id", nullable = false, unique = true, length = 50)
    private String emailId;

    @Column(name = "mobile", nullable = false, unique = true )
            private String mobile;

   /* @Column (name="ceratedAt" , nullable = false)
            @CreationTimestamp
                private Date createdAt;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}