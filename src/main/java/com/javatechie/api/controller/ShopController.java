package com.javatechie.api.controller;


import com.javatechie.api.entity.Shop;
import com.javatechie.api.exception.UserNotFoundException;
import com.javatechie.api.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mypage")
public class ShopController {
    @Autowired
    private ShopService service;

    @PostMapping("/signup")
    public ResponseEntity<String> saveShop(@Valid @RequestBody Shop shop){
        Shop count=service.saveShop(shop);
    return new ResponseEntity<String>("Entry recorded with id "+count, HttpStatus.CREATED);

    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Shop>> getAllShop(){
        return ResponseEntity.ok(service.getAllShop());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shop>> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getShop(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable("id") int id) throws UserNotFoundException {
        //return ResponseEntity.ok(service.deleteShop(id));
        service.deleteShop(id);
        return new ResponseEntity<String>("UserId "+id+" deleted successfully!.",HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateShop(@PathVariable("id") int id
            ,@RequestBody Shop shop)throws UserNotFoundException{
        Shop shop2=service.getShopById(id);
        if(shop2==null){

            return new ResponseEntity<String>(""+ id,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<String>(service.updateShop(shop, id),HttpStatus.OK);

        }
        }


}
