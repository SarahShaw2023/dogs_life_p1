import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// import batman from '../images/batman_bongo_cat.jpeg'
// import h1 from '../images/1.jpeg';
// import h2 from '../images/2.jpeg';
// import h3 from '../images/3.jpeg';
// import h4 from '../images/4.jpeg';
// import h5 from '../images/5.jpeg';
// import h6 from '../images/6.jpeg';
// import h7 from '../images/7.jpeg';
// import h8 from '../images/8.jpeg';
// import h9 from '../images/9.jpeg';
// import h10 from '../images/10.jpeg';

import Batman from "./images/1.jpeg";
import Superman from "./images/2.jpeg";
import GreenLantern from "./images/4.jpeg";
import TheHuntress from "./images/5.jpeg";
import TheFlash from "./images/3.jpeg";
import HarleyQuinn from "./images/6.jpeg";
import Deadshot from "./images/7.jpeg";
import CountVertigo from "./images/8.jpeg";
import Robin from "./images/9.jpeg";
import Nightwing from "./images/10.jpeg";

const images = {
    Batman,
    Superman,
    GreenLantern,
    TheHuntress,
    TheFlash,
    HarleyQuinn,
    Deadshot,
    CountVertigo,
    Robin,
    Nightwing
}

// const hero = {
//     "id":1,
//     "name":"Bruce Wayne",
//     "alias":"Batman",
//     "superpower":"Martial Arts",
//     "teamID":1
// }

// const images = {
//   h1, h2, h3, h4, h5, h6, h7, h8, h9, h10
// };

export default images;

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
