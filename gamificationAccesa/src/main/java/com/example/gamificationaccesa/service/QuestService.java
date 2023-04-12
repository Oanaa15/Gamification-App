package com.example.gamificationaccesa.service;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.domain.validators.*;
import com.example.gamificationaccesa.repository.*;

import java.util.*;

public class QuestService {
    //UserValidator userValidator;
    QuestDatabaseRepository repo = QuestDatabaseRepository.getInstance();

    private static QuestService instance = null;
    private QuestService() {
    }
    public static QuestService getInstance() {
        if(instance == null) {
            instance = new QuestService();
        }
        return instance;
    }

    public void add(Quest q) {
        System.out.println(q);
        repo.save(q);
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

    public void update(Quest q) {
        if(repo.getOne(q.getId()) == null){
            throw new RuntimeException("There is no such id!");}
        repo.update(q);
    }

    public Iterable<Quest> getAll() {
        return repo.getAll();
    }

    public ArrayList<Quest> getAllList() {
        return repo.getAllList();
    }

    public Quest getById(long id) {
        return repo.getOne(id);
    }

    public Long lastid(){
        Long id = 0L;
        for(Quest u: repo.getAll()){
            if(u.getId() > id)
                id = u.getId();
        }
        return id + 1;
    }
}
