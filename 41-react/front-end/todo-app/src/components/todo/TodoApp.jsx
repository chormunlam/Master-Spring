import { useState } from "react";
import "./TodoAPP.css";
import {
  BrowserRouter,
  Routes,
  Route,
  useNavigate,
  useParams,
  Link,
} from "react-router-dom";

export default function TodoApp() {
  return (
    <div className="TodoApp">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />

          <Route path="/todos" element={<ListTodosComponent />} />
          <Route path="/logout" element={<LogoutComponent />} />
          <Route path="*" element={<ErrorComponent />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

function LoginComponent() {
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

  function handleSubmit() {
    // console.log(pw);
    // console.log(username);
    //tyr the hardcoded creditial
    if (username === "in28mins" && pw === "dummy") {
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
function WelcomeComponent() {
  const { username } = useParams();
  console.log(username);
  return (
    <div className="WelcomeComponent">
      <h1>Welcome ~ {username}</h1>
      <div>
        mananger yourtodos. -<Link to="/todos">go here</Link>
      </div>
    </div>
  );
}

function ErrorComponent() {
  return (
    <div className="ErrorComponent">
      <h1>sorry for the 404, reach out to our tema at xx</h1>{" "}
    </div>
  );
}

function ListTodosComponent() {
  const today = new Date();

  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );
  const todos = [
    {
      id: 1,
      desc: "Learn AWS",
      done: false,
      targetDate: targetDate,
    },
    {
      id: 2,
      desc: "Learn full",
      done: false,
      targetDate: targetDate,
    },
    {
      id: 3,
      desc: "Learn Cloud",
      done: false,
      targetDate: targetDate,
    },
  ];
  return (
    <div className="container">
      <h1>things you want to have fun with</h1>
      <div>
        <table className="table">
          <thead>
            <tr>
              <td>Id</td>
              <td>Desc</td>
              <td>Is Done?</td>
              <td>Target Date</td>
            </tr>
          </thead>

          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.desc}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

function Header() {
  return (
    <header className="border-bottom border-light border-5 mb-5 p-2">
      <div className="container">
        <div className="row">
          <nav className="navbar navbar-expand-lg">
            <a
              className="navbar-brand ms-2 fs-2 fw-bold text-black"
              href="https://www.in28minutes.com"
            >
              in28minutes
            </a>
            <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                <li className="nav-item fs-5">
                  <Link className="nav-link" to="/welcome/in28minutes">
                    Home
                  </Link>
                </li>
                <li className="nav-item fs-5">
                  <Link className="nav-link" to="/todos">
                    Todos
                  </Link>
                </li>
              </ul>
            </div>
            <ul className="navbar-nav">
              <li className="nav-item fs-5">
                <Link className="nav-link" to="/login">
                  Login
                </Link>
              </li>
              <li className="nav-item fs-5">
                <Link className="nav-link" to="/logout">
                  Logout
                </Link>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </header>
  );
}

function Footer() {
  return (
    <footer className="footer">
      <div className="container">your footer</div>
    </footer>
  );
}

function LogoutComponent() {
  return (
    <div className="logout">
      <h1>logged out</h1>{" "}
    </div>
  );
}
