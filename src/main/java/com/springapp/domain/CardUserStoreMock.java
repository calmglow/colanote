package com.springapp.domain;

import java.util.*;
/**
 * Created by 1109294 on 14. 2. 5.
 */
public class CardUserStoreMock {
    public static HashMap<String,Card> cardStore;
    public static HashMap<String,User> userStore;

    public static void add(Card card){
        if (cardStore==null)cardStore = new HashMap<String,Card>();
        cardStore.put(card.getId(),card);
    }

    public static void add(User user){
        if (userStore==null) userStore = new HashMap<String,User>();
        userStore.put(user.getId(),user);
    }
    public static void removeCard(String id){ cardStore.remove(id); }
    public static void removeUser(String id){ userStore.remove(id); }

    public static Collection<Card> cardList(){ return cardStore.values(); }

    public static Collection<User> userList(){ return userStore.values();}

    public static Card getCard(String id){ return cardStore.get(id); }

    public static User getUser(String id){ return userStore.get(id); }

    public static boolean setUser(User user){
        userStore.put(user.getId(),user);
        return true;
    }
    public static boolean setCard(Card card){
        cardStore.put(card.getId(),card);
        return true;
    }
}
