import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
  const [username, setUsername] = useState("in28mins");
  function handleUserNameChange(event) {
    //console.log(event.target.value);
    setUsername(event.target.value);
  }

  const [pw, setPw] = useState("");
  function handlePwChange(event) {
    console.log(event.target.value);
    setPw(event.target.value);
  }

  const [showSucess, setShowSucess] = useState(false);
  const [showError, setShowError] = useState(false);

  const navigate = useNavigate();

  const authContext = useAuth();

  function handleSubmit() {
    // console.log(pw);
    // console.log(username);
    //tyr the hardcoded creditial
    if (username === "in28mins" && pw === "dummy") {
      authContext.setAuth(true);
      console.log("sucess");
      setShowSucess(true);
      setShowError(false);
      navigate(`/welcome/${username}`);
    } else {
      console.log("fail");
      setShowError(true);
      setShowSucess(false);
    }
  }

  return (
    <div className="Login">
      <h1>Login here</h1>
      {showSucess && (
        <div className="sucessMessage"> Authenticated Succesfully</div>
      )}
      {showError && (
        <div className="errorMessage">
          Authenticated Failed, plz check credentials{" "}
        </div>
      )}
      <div className="LoginForm">
        <div>
          <label>Username</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUserNameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={pw}
            onChange={handlePwChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
