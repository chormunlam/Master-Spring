import { createContext, useContext, useState } from "react";

//1. create a context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);
//2. put some state in the context

export default function AuthProvider({ children }) {
  //3share the created context with other components

  const [isAuth, setAuth] = useState(false);
  const [username, setUsername] = useState(null);

  function login(username, pw) {
    if (username === "cc" && pw === "22") {
      setAuth(true);
      //console.log("sucess");
      setUsername(username);
      return true;
    } else {
      setAuth(false);
      setUsername(null);
      return false;
    }
  }

  function logout() {
    setAuth(false);
    setUsername(null);
  }

  //setInterval(() => setNumber(number + 1), 10000); //inc the number every 10 sec

  //const valueToBeShared = { number, isAuthenticated, setAuthenticated };
  return (
    <AuthContext.Provider value={{ isAuth, login, logout, username }}>
      {children}
    </AuthContext.Provider>
  );
}
