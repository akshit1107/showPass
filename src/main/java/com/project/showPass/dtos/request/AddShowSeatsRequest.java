package com.project.showPass.dtos.request;

import lombok.Data;

@Data
public class AddShowSeatsRequest {

    private Integer showId;
    private Integer priceClassic;
    private Integer pricePremium;
    private Integer priceLuxury;

}