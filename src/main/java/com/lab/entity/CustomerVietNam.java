package com.lab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerVietNam extends Customer {
    String customerType;
    double limit;

    @Override
    public double calculateTotal() {
        if (quantity <= limit) {
            return quantity * unitPrice;
        } else {
            return (limit * unitPrice) + ((quantity - limit) * unitPrice * 2.5);
        }
    }

}
