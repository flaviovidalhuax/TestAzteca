package com.example.userJWT.service;
import com.example.userJWT.dto.CreateUserDTO;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired(required=true)
    UserEntity userEntity;
    @Autowired(required=true)
    UserRepository userRepository;
    public List<UserEntity> allUSer(){
        return (List<UserEntity>) userRepository.findAll();
    }
    public UserEntity postUser( UserEntity userEntity){
        return userRepository.save(userEntity);
    }
    public List<Object> userByNombre(String nombre) {


        List<UserEntity> data = (List<UserEntity>) userRepository.findByNombre(nombre);
        List<Object> resp = null;
        for (UserEntity val : data) {
            String name;
            String fecha;
            if (val.getNombre() == nombre) {
                name = val.getNombre();
                fecha = val.getBirtDay();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
                LocalDate daynow = LocalDate.now();//1992-03-18
                long diferenciaEnDias = ChronoUnit.DAYS.between(fechaLocalDate, daynow);
                Long Plazo = diferenciaEnDias;
                resp = new ArrayList<>();
                resp.add(name);
                resp.add(Plazo);
            }

        }
        return resp;
    }
    public  void deleteUser(Long id){

    userRepository.deleteById(id);
    }
}
