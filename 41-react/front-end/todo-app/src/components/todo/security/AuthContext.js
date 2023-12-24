import { createContext, useContext, useState } from "react";

//1. create a context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);
//2. put some state in the context

export default function AuthProvider({ children }) {
  //share the created context with other components
  const [number, setNumber] = useState(10);
  const [isAuth, setAuth] = useState(false);

  //setInterval(() => setNumber(number + 1), 10000); //inc the number every 10 sec

  //const valueToBeShared = { number, isAuthenticated, setAuthenticated };
  return (
    <AuthContext.Provider value={{ number, isAuth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
}
