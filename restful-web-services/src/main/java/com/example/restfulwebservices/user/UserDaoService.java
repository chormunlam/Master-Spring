package com.example.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {//for dataacess , data access object. to operate the data
   //let create some static data
    // JPA/Hibernate > Database
    // UserDaoServiceStatic Lists
    private static List<User> users= new ArrayList<>();
    private static int userCount=0;
    static {
        users.add(new User(++userCount,"adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"jan", LocalDate.now().minusYears(40)));

    }

    //public list<User> findall(){}
    public List<User> findall(){
        return users;
    }
    //save user
    //find one user
    public User findOne(int id){
        Predicate<? super User> predicate= user->
                user.getId().equals(id);
        //convert the list to strem
        return users.stream().filter(predicate).findFirst().get();
    }

    //save
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
