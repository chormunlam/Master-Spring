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

  //const [showSucess, setShowSucess] = useState(false); we got redicret now
  const [showError, setShowError] = useState(false);

  const navigate = useNavigate();

  const authContext = useAuth();

  function handleSubmit() {
    // console.log(pw);
    // console.log(username);
    //tyr the hardcoded creditial
    if (authContext.login(username, pw)) {
      navigate(`/welcome/${username}`);
    } else {
      setShowError(true);
    }
  }

  return (
    <div className="Login">
      <h1>Login here</h1>

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
