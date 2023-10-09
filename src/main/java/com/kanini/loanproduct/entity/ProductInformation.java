package com.kanini.loanproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"productAvailability","LoanAmount,AccountSettings","InterestRate","Repayments"})
@ToString(exclude = {"productAvailability","LoanAmount,AccountSettings","InterestRate","Repayments"})
@Table(name="product_info")
public class ProductInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_category")
    private String productCategory;

    @Column(name="product_type")
    private String productType;

    @Column(name="product_description")
    private String productDescription;


    private Boolean status;

    LocalDate lastModified= LocalDateTime.now().toLocalDate();

    @OneToOne(mappedBy = "productInformation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductAvailability productAvailability;

    @OneToOne(mappedBy = "productInformation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccountSettings accountSettings;

    @OneToOne(mappedBy = "productInformation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LoanAmount loanAmount;

    @OneToOne(mappedBy = "productInformation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private InterestRate interestRate;

    @OneToOne(mappedBy = "productInformation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Repayments repayments;
}
