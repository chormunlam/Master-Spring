import { useContext } from "react";
import { useAuth } from "./security/AuthContext";

export default function Footer() {
  // const authContext = useAuth();

  //console.log(authContext.number);
  return (
    <footer className="footer">
      <div className="container">your footer</div>
    </footer>
  );
}
