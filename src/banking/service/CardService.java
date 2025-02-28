package banking.service;

import banking.model.Card;

import java.io.*;

public class CardService {

    public void createCardFile(Card[] cards) throws IOException {

        try (   FileOutputStream fileOutputStream=new FileOutputStream("card.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

            objectOutputStream.writeObject(cards);
        }
    }
    public Card[] getCards() throws IOException,ClassNotFoundException {
        Card[] cards=null;
        try (FileInputStream fileInputStream = new FileInputStream("card.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

             cards= (Card[]) objectInputStream.readObject();
        }
        return cards;
    }


}
