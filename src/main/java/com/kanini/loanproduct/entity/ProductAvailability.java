package com.kanini.loanproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, exclude = {"productInformation"})
@ToString(exclude={"productInformation"})
@Table(name="product_availability")
public class ProductAvailability {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_available")
    private String productAvailable;

    @Column (name="branches")
    private String branches;

    @OneToOne
    @JoinColumn(name="product_id")
    @MapsId
    @JsonBackReference
    private ProductInformation productInformation;

}
