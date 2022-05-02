package com.javatechie.api.service;

import com.javatechie.api.entity.Shop;
import com.javatechie.api.exception.UserNotFoundException;
import com.javatechie.api.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public Shop saveShop(Shop shop) {
        shop.setTotal(calculateTotal(shop.getGst(),shop.getItemPrice() ));
        return shopRepository.save(shop);
    }
    public List<Shop> getAllShop() {

            return shopRepository.findAll();

    }

    public Optional<Shop> getShop(int id) throws UserNotFoundException {
        Optional<Shop> shop= shopRepository.findById(id);
        if(shop.isPresent()){
            return Optional.of(shop.get());
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }

    public String deleteShop(int id) throws UserNotFoundException{
        Optional<Shop> del=shopRepository.findById(id);
        if(del.isPresent()) {
            shopRepository.deleteById(id);
            return "User id "+id+" is deleted";
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }


    public Shop getShopById(int id) throws UserNotFoundException{

		Optional<Shop> shop = shopRepository.findById(id);

	    if(shop.isPresent()) {
    	return shop.get();
          }else {

   throw new UserNotFoundException("user not found with id : "+id);
          }

    }
    public String updateShop(Shop shop, int id) throws UserNotFoundException{
        Shop upd=shopRepository.findById(id).get();
        if(upd!=null){

            //upd.setItemid(shop.getItemid());
            upd.setItemName(shop.getItemName());
            upd.setItemPrice(shop.getItemPrice());
            upd.setGst(shop.getGst());
            //upd.setTotal(shop.getTotal());
            upd.setTotal(calculateTotal(shop.getGst(),shop.getItemPrice() ));
            upd.setExpdate(shop.getExpdate());
            //save existing shop to DB
            shopRepository.save(upd);
            return "User id "+id+" is updated successfully! \n and total is "+calculateTotal(upd.getGst(), upd.getItemPrice())+"";
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }



    }
    public String calculateTotal(String gst, String itemPrice) {

        double gs= Double.parseDouble(gst);
        double ip=Double.parseDouble(itemPrice);

        double total=0.0;

        total=((gs/100.0)*ip)+ip;
        String total1=""+total;
        return total1;
    }


}
