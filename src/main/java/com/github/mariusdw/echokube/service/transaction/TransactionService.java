package com.github.mariusdw.echokube.service.transaction;

import java.util.*;

public class TransactionService {
    public class InvalidUserException extends Exception {
        public InvalidUserException(String msg) {

        }
    }

    protected class User {

    }

    protected interface UserClient {
        Optional<User> lookupUser(long userID);
    }

    protected interface TransactionClient {
        void createTransaction(long UserID, long amount);
    }

    private UserClient uc;
    private TransactionClient tc;

    public TransactionService(UserClient uc, TransactionClient tc) {
        this.uc = uc;
        this.tc = tc;
    }

    public void addTransaction(long userID, long amount) throws Exception {
        Optional<User> u = uc.lookupUser(userID);
        if (!u.isPresent()) {
            throw new InvalidUserException("User not found") ;
        }

        tc.createTransaction(userID, amount);
    }
}
