package com.javatechie.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "SHOP_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue
    private int itemid;
    @NotEmpty(message = "Please Enter itemName in word format")
    private String itemName;
    public String toString() {
        return ""+itemid+"\n Your total is= "+total+"";

    }
   @NotBlank(message = "Please Enter itemPrice in number format")
    private String itemPrice;
    //@Min(1)
    //@Max(30)
    @Range(min=1,max=30,message="GST should be in Range of 1 and 30")
    @NotBlank
    private String gst;

    private String total;
    @NotEmpty(message = "Please Enter Expiration Date")
    private String expdate;

}
