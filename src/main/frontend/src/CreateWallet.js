import "./css/CreateWallet.css"
import {useState} from "react";
import axios from "axios";

function CreateWallet(){
    const [walletAddress, setWalletAddress] = useState('');

    const generateNewAddress = () => {
        axios.get('/api/v1/eth/create') // API 엔드포인트에 맞게 경로를 수정해야 합니다.
            .then(response => {
                // const address = response.data.walletFileName; // 응답에서 주소를 가져옵니다.
                // setWalletAddress(address); // 가져온 주소를 상태로 설정합니다.
                console.log("response : " + response);
            })
            .catch(error => {
                console.error('주소 생성에 실패했습니다.', error);
            });
    }

    return (
        <div className={"container"}>
            <input type={"button"} value={"지갑 생성"} onClick={generateNewAddress} />
            <input type={"text"} readOnly value={walletAddress}/>
        </div>
    )
}

export default CreateWallet;