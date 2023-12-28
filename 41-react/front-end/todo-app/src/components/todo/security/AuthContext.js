import { createContext, useContext, useEffect, useState } from "react";
import { apiClient } from "../api/apiClient";
import { excuteBasicAuthService } from "../api/HelloWorldApiService";

//1. create a context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);
//2. put some state in the context

export default function AuthProvider({ children }) {
  //3share the created context with other components

  const [isAuth, setAuth] = useState(false);
  const [username, setUsername] = useState(null);

  // function login(username, pw) {
  //   if (username === "cc" && pw === "22") {
  //     setAuth(true);
  //     //console.log("sucess");
  //     setUsername(username);
  //     return true;
  //   } else {
  //     setAuth(false);
  //     setUsername(null);
  //     return false;
  //   }
  // }
  const [token, setToken] = useState(null);

  async function login(username, pw) {
    const baToken = "Basic " + window.btoa(username + ":" + pw);

    try {
      const response = await excuteBasicAuthService(baToken);

      if (response.status == 200) {
        setAuth(true);
        //console.log("sucess");
        setUsername(username);
        setToken(baToken);
        //make all call add toker to header
        apiClient.interceptors.request.use((config) => {
          console.log("interrecpting and adding token: " + baToken);
          config.headers.Authorization = baToken; //very import
          return config;
        });
        return true;
      } else {
        // setAuth(false);
        // setUsername(null);
        // setToken(null)
        logout();
        return false;
      }
    } catch (error) {
      // setAuth(false);
      // setUsername(null);
      // setToken(null)
      logout();
      return false;
    }
  }

  //   .then((res) => console.log("1" + res))
  //   .catch((err) => console.log(err));
  // console.log("test");

  // setAuth(false);

  function logout() {
    setAuth(false);
    setUsername(null);
    setToken(null);
  }

  //setInterval(() => setNumber(number + 1), 10000); //inc the number every 10 sec

  //const valueToBeShared = { number, isAuthenticated, setAuthenticated };
  return (
    <AuthContext.Provider value={{ isAuth, login, logout, username, token }}>
      {children}
    </AuthContext.Provider>
  );
}
