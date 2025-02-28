package banking;

import banking.TrasactionException.TransactionException;
import banking.model.Card;
import banking.model.Transaction;
import banking.service.CardService;
import banking.service.TransactionService;

import java.io.IOException;
import java.util.Arrays;



public class NewThread extends Thread {
    @Override
    public synchronized void run() {
        Card card = new Card("4169 7388 1234 5678", 100);
        Card card1 = new Card("4098 5844 9876 5432", 500);
        Card card2 = new Card("5236 7654 3210 6789", 1000);

        Card[] cards=new Card[]{card1,card2,card};




        CardService cardService=new CardService();
        try {
            cardService.createCardFile(cards);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Card[] cardss;
        try {
            cardss = cardService.getCards();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(cardss));
        System.out.println();

        TransactionService transactionService=new TransactionService();
        try {
            transactionService.createTransaction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Transaction[] transactions;
        try {
            transactions = transactionService.getTransaction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Transaction[] transactions1;
        try {
            transactions1 = transactionService.getTransactionInfo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(transactions));
        System.out.println(Arrays.toString(transactions1));

        System.out.println("new balance:"+ Arrays.toString(cardss));
        try {
            cardService.createCardFile(cardss);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            cardss=cardService.getCards();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        try {
            mannerTransaction(cards,transactions1);
        } catch (TransactionException e) {
            throw new RuntimeException(e);
        }

    }

    public static Card[] mannerTransaction(Card[] cards, Transaction[] transactions) throws TransactionException {
        for (Transaction transaction:transactions) {
            for (Card card:cards){
                if (card.getPan().equals(transaction.getPan())) {
                    double newBalance=card.getAmount()-transaction.getAmount();
                    if (newBalance<0){
                        throw new TransactionException("Insufficente Balance");
                    }
                    card.setAmount(card.getAmount()-transaction.getAmount());
                }
            }
        }
        return cards;
    }
}
