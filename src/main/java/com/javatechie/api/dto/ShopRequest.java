/*package com.javatechie.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ShopRequest {

    private int itemid;
    @NotBlank//(message = "Can't be Null")
    private String itemName;
    @NotEmpty
    private String itemPrice;
    @Min(1)
    @Max(30)
    private String gst;
    private String total;
    private String expdate;

}

 */
