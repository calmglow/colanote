package com.springapp.mvc;

import com.springapp.domain.Card;
import com.springapp.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/")
public class CardController {
    @RequestMapping(value="/card", method= RequestMethod.POST,consumes = "application/json")
    public void insertCard(@RequestBody Card card, ModelMap model){
        CardService cardSvc = new CardService();
        String cardId = cardSvc.save(card);
        model.addAttribute("cardId",cardId);
    }

    @RequestMapping(value="/card", method = RequestMethod.GET)
    public void listCard(ModelMap model){
        Collection<Card> cards = new CardService().list();
        model.addAttribute("cards",cards);
    }
    @RequestMapping(value="/card/{cardId}", method= RequestMethod.GET)
    public void getCard(@PathVariable String cardId, ModelMap model){

        CardService cardSvc = new CardService();
        Card card = cardSvc.get(cardId);
        model.addAttribute("card",card);
    }

    @RequestMapping(value="/card/{cardId}", method= RequestMethod.PUT)
    public void setCard(@PathVariable String cardId, @RequestBody Card card, ModelMap model){
        CardService cardSvc = new CardService();
        Card originalCard = cardSvc.get(cardId);
        BeanUtils.copyProperties(card,originalCard,new String[]{"id","createdDate"});
        cardSvc.set(originalCard);
        model.addAttribute("cardId", originalCard.getId());
    } 
    @RequestMapping(value="/card/{cardId}", method= RequestMethod.DELETE)
    public void deleteCard(@PathVariable String cardId, ModelMap model){
        new CardService().delete(cardId);
        model.addAttribute("message","Okay");
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public void hello2(ModelMap model){
        model.addAttribute("message","Hello Jinho!!");
    }
}