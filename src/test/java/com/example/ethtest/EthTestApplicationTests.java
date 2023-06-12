package com.example.ethtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@SpringBootTest
class EthTestApplicationTests {
    private static final String RPC_URL = "http://127.0.0.1:8545";
    private static final String PASSWORD = "Coinbit12!@";
    private static final String WALLET_FILE = ""; // 지갑 주소를 저장 할 경로
    private Web3j web3j;

    public void main() {
        // Web3j 초기화
        web3j = Web3j.build(new HttpService(RPC_URL));
        System.out.println(web3j);
    }
    @Test
    void contextLoads() {
        main();
    }

}
