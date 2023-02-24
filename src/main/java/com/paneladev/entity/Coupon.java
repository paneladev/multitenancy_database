package com.paneladev.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    private Long id;

    private String code;
}
