package com.cmd.payload;


import jakarta.validation.constraints.*;

import java.util.Date;

public class EmployeeDto {
    private long id;

    @NotBlank(message = "Name Should be provided cannot be empty")
    @Size(min = 3, message = "atleast 3 characters required")
    private String name;

    @NotNull(message = "Email should be provided")
    @Email
    private String emailId;

    @Size(min = 10, max = 10, message = "10 digits required")
    private String mobile;
    //  private Date date;

    //private Date createdAt;

    public long getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public void setId(long id) {
        this.id = id;
    }
}
