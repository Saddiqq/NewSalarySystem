package com.Hisham.Ecommerce.Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Setter
@Getter
@Data

public class BaseEntity {
    @CreatedDate
    Date createdDate;
    @UpdateTimestamp
    Date updatedDate;

    Boolean isActive;
}
