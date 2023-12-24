import { createContext, useContext, useState } from "react";

//1. create a context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);
//2. put some state in the context

export default function AuthProvider({ children }) {
  //3share the created context with other components

  const [isAuth, setAuth] = useState(false);

  function login(username, pw) {
    if (username === "in28mins" && pw === "dummy") {
      setAuth(true);
      //console.log("sucess");
      return true;
    } else {
      setAuth(false);
      return false;
    }
  }

  function logout() {
    setAuth(false);
  }

  //setInterval(() => setNumber(number + 1), 10000); //inc the number every 10 sec

  //const valueToBeShared = { number, isAuthenticated, setAuthenticated };
  return (
    <AuthContext.Provider value={{ isAuth, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}
