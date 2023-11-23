package com.ms.idm.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "created_at")
//    @CreatedDate
    @CreationTimestamp
    private Timestamp createdAt;
}
