import "./css/CreateWallet.css"

function CreateWallet(){


    return (
        <div className={"container"}>
            <input type={"button"} value={"지갑 생성"}/>
            <input type={"text"} readOnly />
        </div>
    )
}

export default CreateWallet;