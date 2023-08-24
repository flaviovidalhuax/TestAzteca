package com.example.userJWT.service;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


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


        List<UserEntity> data =  userRepository.findByNombre(nombre);
        List<Object> resp = null;
        for (UserEntity val : data) {
            String name;
            String fecha;
            if (val.getNombre() == nombre) {
                name = val.getNombre();
                System.out.println("val.getNombre() = " + val.getNombre());
                fecha = val.getBirtDay();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
                LocalDate daynow = LocalDate.now();//1992-03-18
                long diferenciaEnYears = ChronoUnit.YEARS.between(fechaLocalDate, daynow);
                System.out.println("YEARS= " + diferenciaEnYears);
                Long Plazo = diferenciaEnYears;
                resp = new ArrayList<>();
                resp.add("nombre: "+name);
                resp.add("años: "+Plazo);
            }



        }
        return resp;
    }
    public  void deleteUser(Long id){

    userRepository.deleteById(id);
    }
}
