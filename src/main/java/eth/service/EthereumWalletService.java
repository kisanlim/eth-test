package eth.service;

import org.springframework.stereotype.Service;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class EthereumWalletService {
    private static final String RPC_URL = "https://mainnet.infura.io/v3/2c25d68e560b4b04a0d5a6b117243122";
    private static final String PASSWORD = "Coinbit12!@";
    private static final String WALLET_FILE = ""; // 지갑 주소를 저장 할 경로

    private Web3j web3j;

    public EthereumWalletService() {
        // Web3j 초기화
        web3j = Web3j.build(new HttpService(RPC_URL));
    }

    public String createWallet() {
        try {
            // 새로운 지갑 파일 생성
            String walletFileName = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
            System.out.println("sdaf");
            // 생성된 지갑 파일 이름 반환
            return walletFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BigDecimal getBalance(String walletAddress) {
        try {
            // 계정의 잔액 조회
            EthGetBalance balanceResponse = web3j.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST).send();
            BigInteger weiBalance = balanceResponse.getBalance();
            // Wei에서 Ether로 변환
            BigDecimal etherBalance = new BigDecimal(weiBalance).divide(BigDecimal.TEN.pow(18));
            return etherBalance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    // 추가적인 기능들을 구현할 수 있습니다.
    // 예: 송금, 스마트 컨트랙트 호출 등

    public static void main(String[] args) {
        EthereumWalletService walletService = new EthereumWalletService();

        // 새로운 지갑 파일 생성
        String newWalletFile = walletService.createWallet();
        System.out.println("새로운 지갑 파일: " + newWalletFile);

        // 잔액 조회
        String walletAddress = "0x123456789abcdef";
        BigDecimal balance = walletService.getBalance(walletAddress);
        System.out.println("잔액: " + balance + " Ether");
    }
}
