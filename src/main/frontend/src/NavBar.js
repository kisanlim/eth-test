import {NavLink,Link} from "react-router-dom";
import "./css/NavBar.css"

function NavBar() {



    return (<div className={"nav"}>
     <Link to={"/createWallet"}>
         <li>새로운 지갑 생성</li>
     </Link>
     <NavLink to={"/searchWallet"}>
         <li>보유량 확인</li>
     </NavLink>
     <Link to={"/makeTransaction"}>
         <li>트랜잭션 생성</li>
     </Link>
     </div>)
}

export default NavBar;