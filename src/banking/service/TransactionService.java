package banking.service;

import banking.model.Card;
import banking.model.Transaction;

import java.io.*;

public class TransactionService {
    public void createTransaction() throws IOException {
        Transaction transaction = new Transaction("4169 7388 1234 5678",200);
        Transaction transaction1 = new Transaction("4098 5844 9876 5432",500);

        Transaction[] transactions=new Transaction[]{transaction};
        try (FileOutputStream fileOutputStream=new FileOutputStream("Cash In");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

            objectOutputStream.writeObject(transactions);
        }
        Transaction[] transactions1=new Transaction[]{transaction1};

        try(FileOutputStream fileOutputStream=new FileOutputStream("Cash Out");
       ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(transactions1);
        }
    }
    public Transaction[] getTransaction() throws IOException,ClassNotFoundException {
        Transaction[] transactions=null;
        try (FileInputStream fileInputStream = new FileInputStream("Cash In");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            transactions= (Transaction[]) objectInputStream.readObject();
        }
        return transactions;
    }
    public Transaction[] getTransactionInfo() throws IOException, ClassNotFoundException {
        Transaction[] transactions=null;
        try(FileInputStream fileInputStream = new FileInputStream("Cash Out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            transactions=(Transaction[]) objectInputStream.readObject();
        }
        return transactions;
    }
}
