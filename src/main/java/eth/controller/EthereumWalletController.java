package eth.controller;

import eth.service.EthereumWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/eth")
public class EthereumWalletController {

    private final EthereumWalletService walletService;

    @Autowired
    public EthereumWalletController(EthereumWalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/create")
    public String createWallet() {
        return walletService.createWallet();
    }

    @GetMapping("/balance/{address}")
    public BigDecimal getBalance(@PathVariable String address) {
        return walletService.getBalance(address);
    }
}
