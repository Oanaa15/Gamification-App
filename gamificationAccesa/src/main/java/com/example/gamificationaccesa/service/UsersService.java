package com.example.gamificationaccesa.service;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.domain.validators.*;
import com.example.gamificationaccesa.repository.*;

import java.util.*;
import java.util.stream.*;

public class UsersService {
    UserValidator userValidator;
    UserDatabaseRepository repo = UserDatabaseRepository.getInstance();

    private static UsersService instance = null;
    private UsersService() {
    }
    public static UsersService getInstance() {
        if(instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    public void add(User u) {
        System.out.println(u);
        repo.save(u);
    }

    public void delete(Long l) {
        if(repo.getOne(l) == null)
            throw new RuntimeException("Id-ul nu exista!");
        repo.delete(l);
        //for(Friendship friendship: repoFriendship.getAll()){
        //    if(Objects.equals(l, friendship.getUser1()) || Objects.equals(l, friendship.getUser2())){
        //        repoFriendship.delete(friendship.getId());
        //    }
        //}
    }

    public void update(User u) {
        if(repo.getOne(u.getId()) == null){
            throw new RuntimeException("There is no such id!");}
        repo.update(u);
    }

    public Iterable<User> getAll() {
        return repo.getAll();
    }

    public ArrayList<User> getAllList() {
        return repo.getAllList();
    }

    public User getById(long id) {
        return repo.getOne(id);
    }

    public Long lastid(){
        Long id = 0L;
        for(User u: repo.getAll()){
            if(u.getId() > id)
                id = u.getId();
        }
        return id + 1;
    }

    public List<User> ranking(){
        ArrayList<User> list = getAllList();
        List<User> listRanking = list.stream()
                .sorted(Comparator.comparing(User::getTokens).reversed())
                .collect(Collectors.toList());
        return listRanking;
    }

    public void updateTolkens(User user, int tokens){
        user.setTokens(tokens);
        System.out.println(user);
        update(user);
}
}

