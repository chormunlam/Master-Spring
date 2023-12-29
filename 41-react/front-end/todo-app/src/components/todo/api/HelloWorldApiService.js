import axios from "axios";
import { apiClient } from "./apiClient";
// export function retrieveHelloWorldBean() {
//   return axios.get("http://localhost:8080/hello-world-bean");
// }
//same

export const retrieveHelloWorldBean = () => apiClient.get("/hello-world-bean");

//Response to preflight request donsn't pass access control check=> authorization header
export const retrieveHelloWorldPathVar = (username, token) =>
  apiClient.get(
    `/hello-world/path-variable/${username}`
    // {
    //   headers: {
    //     Authorization: token,
    //   },
    // }dont need it , code below got every thing
  );
