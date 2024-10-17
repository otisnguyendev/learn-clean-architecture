package com.lab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerForeigner extends Customer {
    String nationality;

    @Override
    public double calculateTotal() {
        return quantity * unitPrice;
    }
}
