package com.blitmatthew.spring_mvc.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Cybrog {
    private String name;
    private String alloy;
    private String serialNumber;
    private Integer noOfWeapons;
    private Integer noOfCpus;
    private Integer storage;
}
