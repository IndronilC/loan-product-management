//package com.kanini.loanproduct.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table (name="account_settings")
//public class AccountSettings {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;
//
//    @Column(name = "id_type")
//    private String idType;
//
//    @Column(name="template")
//    private String template;
//
//    @Column(name = "starting_from")
//    private int startingFrom;
//
//    @Column(name="account_state")
//    private String accountState;
//
//    @OneToOne
//    @JoinColumn(name ="product_id")
//    private ProductInformation productInformation;
//}
