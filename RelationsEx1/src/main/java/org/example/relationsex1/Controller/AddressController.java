package org.example.relationsex1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiResponse;
import org.example.relationsex1.DTO.AddressDTO;
import org.example.relationsex1.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(addressService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress( @PathVariable Integer id ){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address Deleted"));
    }
}
