package com.springapp.service;

import com.springapp.domain.Card;
import com.springapp.domain.CardUserStoreMock;

import java.util.Collection;
import java.util.Random;

/**
 * 안녕하세요 주석 테스트입니다.
 * Created by 1109294 on 14. 2. 6.
 */
public class CardService {

    //private CardUserStoreMock cardStore = null;

    /**
     * 카드를 삭제한다.
     * @param card 삭제할 카드 객체
     */
    public void delete(Card card){
        CardUserStoreMock.removeCard(card.getId());
    }

    /**
     * 카드를 삭제한다
     * @param cardId 삭제할 카드 id
     * @return 잘되면 true
     */
    public boolean delete(String cardId){
        CardUserStoreMock.removeCard(cardId);
        return true;
    }
    public String save(Card card){
        card.setId(Integer.toString(new Random().nextInt()));
        CardUserStoreMock.add(card);

        return card.getId();
    }

    public String set(Card card){
        CardUserStoreMock.setCard(card);
        return card.getId();
    }

    public Collection<Card> list(){
        return CardUserStoreMock.cardList();
    }

    public Card get(String id){
        return CardUserStoreMock.getCard(id);
    }
}
