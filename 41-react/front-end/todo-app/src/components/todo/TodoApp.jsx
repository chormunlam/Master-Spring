import { useState } from "react";
import "./TodoAPP.css";
import {
  BrowserRouter,
  Routes,
  Route,
  useNavigate,
  useParams,
  Link,
  Navigate,
} from "react-router-dom";
import ListTodosComponent from "./ListTodosComponent";
import WelcomeComponent from "./WelcomeComponent";
import LoginComponent from "./LoginComponent";
import LogoutComponent from "./LogoutComponent";
import ErrorComponent from "./ErrorCompoenent";
import Header from "./Header";
import Footer from "./Footer";
import AuthProvider, { useAuth } from "./security/AuthContext";
import TodoComponent from "./TodoComponent";

function AuthenticatedRoute({ children }) {
  const authContext = useAuth();
  if (authContext.isAuth) {
    console.log("isAuth" + authContext.isAuth);
    console.log(children);
    return children;
  }
  return <Navigate to="/" />;
}

export default function TodoApp() {
  return (
    <div className="TodoApp">
      <AuthProvider>
        <BrowserRouter>
          <Header />
          <Routes>
            <Route path="/" element={<LoginComponent />} />
            <Route path="/login" element={<LoginComponent />} />
            <Route
              path="/welcome/:username"
              element={
                <AuthenticatedRoute>
                  <WelcomeComponent />
                </AuthenticatedRoute>
              }
            />

            <Route
              path="/todos"
              element={
                <AuthenticatedRoute>
                  <ListTodosComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="/todo/:id"
              element={
                <AuthenticatedRoute>
                  <TodoComponent />
                </AuthenticatedRoute>
              }
            ></Route>
            <Route path="/logout" element={<LogoutComponent />} />
            <Route path="*" element={<ErrorComponent />} />
          </Routes>
          <Footer />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}
