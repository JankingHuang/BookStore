package com.asxb.bookstore.service;

import java.math.BigInteger;

public interface LoginService {

    BigInteger loginSelect(String userName, String password);
}
