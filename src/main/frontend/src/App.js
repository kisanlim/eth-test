import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import NavBar from "./NavBar";
import SearchWallet from "./searchWallet";
import CreateWallet from "./CreateWallet";

function App() {

  return (<div className="App">
    <header className="App-header">ETH WALLET
    </header>
    메인 페이지임
    <NavBar></NavBar>
   {/* <div className={"nav"}>*/}
   {/*   <Link to={"/createWallet"}><li>새로운 지갑 생성</li></Link>*/}
   {/*   <Link to={"/searchWallet"}><li>보유량 확인</li></Link>*/}
   {/*   <Link to={"/makeTransaction"}><li>트랜잭션 생성</li></Link>*/}
   {/*</div>*/}

    <Routes>
      <Route exact path={"/"} element={<app></app>}></Route>
      <Route path="/createWallet" element={<CreateWallet/>}/>
      <Route path="/searchWallet" element={<SearchWallet/>}/>
      <Route path="/makeTransaction" />
    </Routes>
  </div>);
}

export default App;