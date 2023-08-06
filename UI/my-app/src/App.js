import "./App.css";

import { useRef, useState } from "react";

function App() {
  const [acctID, setAccID] = useState("");
  const [custName, setCustName] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [country, setCountry] = useState("");
  const [phoneno, setPhoneno] = useState("");
  const [password, setPassword] = useState("");

  const sendData = async (event) => {
    event.preventDefault();
    // fetch.post()async

    const data = {
      acctID,
      custName,
      city,
      state,
      country,
      phoneno,
      password,
    };
    console.log(data, "target");
    // s
    const URL = "http://localhost:9393/api/shop/signup";
    // post call cahnge url as per required

    const response = await fetch(URL, {
      method: "POST",
      body: JSON.stringify(data),
    });
    event.target.reset();
    console.log(data, "hey got data");
  };
  return (
    <div className="App">
      <div className="container">
        <div className="inner-section1">
          <div className="global-header">
            <div>english</div>
          </div>
          <div className="header">WELCOME</div>
          <div className="mini-header">welcome to CRUD dashboard</div>
          <form onSubmit={sendData} id="my_form">
            <div className="form-container">
              <input
                type="text"
                id="acctID"
                name="id"
                placeholder="Account ID"
                className="input-form-text"
                value={acctID}
                onChange={(event) => setAccID(event.target.value)}
              />
              <input
                type="text"
                id="custName"
                name="Name"
                placeholder="Customer Name"
                className="input-form-text"
                value={custName}
                onChange={(event) => setCustName(event.target.value)}
              />
              <input
                type="text"
                id="city"
                name="city"
                placeholder="City"
                className="input-form-text"
                value={city}
                onChange={(event) => setCity(event.target.value)}
              />
              <input
                type="text"
                id="state"
                name="state"
                placeholder="State"
                className="input-form-text"
                value={state}
                onChange={(event) => setState(event.target.value)}
              />
              <input
                type="text"
                id="country"
                name="country"
                placeholder="Country"
                className="input-form-text"
                value={country}
                onChange={(event) => setCountry(event.target.value)}
              />
              <input
                type="text"
                id="phoneNo"
                name="phoneNo"
                placeholder="PhoneNumber"
                className="input-form-text"
                value={phoneno}
                onChange={(event) => setPhoneno(event.target.value)}
              />
              <input
                type="text"
                id="password"
                name="password"
                placeholder="password"
                className="input-form-text"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />

              {/* <button className="button-reg">GET</button> */}
              <button className="button-reg">POST</button>
              {/* <button className="button-reg">PUT</button> */}
              {/* <button className="button-reg">DELETE</button> */}
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default App;
