package org.example.relationsex1.Service;

import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiException;
import org.example.relationsex1.DTO.AddressDTO;
import org.example.relationsex1.Model.Address;
import org.example.relationsex1.Model.Teacher;
import org.example.relationsex1.Repository.AddressRepository;
import org.example.relationsex1.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAll(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException("Teacher doesn't exist");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("Address doesn't exist");
        }
        address.setArea(address.getArea());
        address.setStreet(address.getStreet());
        address.setBuildingNumber(address.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("Address doesn't exist");
        }
        addressRepository.delete(address);
    }
}
