package banking;

import banking.TrasactionException.TransactionException;
import banking.model.Card;
import banking.model.Transaction;
import banking.service.CardService;
import banking.service.TransactionService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, TransactionException {
        //iki dene thread yarat hemin fayllarla isleyen taski  birlesdir iki dene file yarat cashin olsun cashout olsun biri cashin icersinde card number amount
//
//        Mythread mythread = new Mythread();
//        NewThread newThread = new NewThread();
//        mythread.start();
//        newThread.start();

        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String[] name = s.split(" ");
        int counter = 0;
        for(String word1:name){
            counter++;
        }
        System.out.println(counter);
        for(String word:name){
            System.out.println(word);
        }


    }

//    public static Card[] processTransaction(Card[] cards,Transaction[] transactions,Transaction[] transactions1) throws TransactionException {
//        for (Transaction transaction:transactions){
//            for (Transaction transaction1:transactions1) {
//                transaction1.getPan();
//                transaction1.getAmount();
//                transaction.getPan();
//                transaction.getAmount();
//                for (Card card:cards){
//                    if (card.getPan().equals(transaction.getPan())) {
//                        card.setAmount(card.getAmount()+transaction.getAmount());
//                    }
//                    if (card.getPan().equals(transaction1.getPan())) {
//                        double newBalance=card.getAmount()-transaction.getAmount();
//                        if (newBalance<0){
//                            throw new TransactionException("Insufficente Balance");
//                        }
//                        card.setAmount(card.getAmount()-transaction.getAmount());
//                    }
//                }
//            }
//
//        }
//        return cards;
//    }
}