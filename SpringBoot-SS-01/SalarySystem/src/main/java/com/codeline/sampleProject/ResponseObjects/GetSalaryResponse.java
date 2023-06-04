package com.codeline.sampleProject.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetSalaryResponse {
    Double amount;

    String currency;

    Double allowances;

    Double bonus;

//    public GetSalaryResponse(Long id, Double amount, String currency) {
//    }


}
