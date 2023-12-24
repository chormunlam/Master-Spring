import { Link, useParams } from "react-router-dom";
import { useState } from "react";
import {
  retrieveHelloWorldBean,
  retrieveHelloWorldPathVar,
} from "./api/HelloWorldApiService";
export default function WelcomeComponent() {
  const { username } = useParams();

  const [message, setMessage] = useState(null);

  function callHelloWorldApi() {
    console.log("called");
    //axios
    // axios
    //   .get("http://localhost:8080/hello-world")
    //   .then((res) => successResponse(res))
    //   .catch((err) => errorResponse(err))
    //   .finally(() => console.log("clean up"));

    // retrieveHelloWorldBean()
    //   .then((res) => successResponse(res))
    //   .catch((err) => errorResponse(err))
    //   .finally(() => console.log("clean up"));

    //
    retrieveHelloWorldPathVar("chormunApi")
      .then((res) => successResponse(res))
      .catch((err) => errorResponse(err))
      .finally(() => console.log("clean up"));
  }

  function successResponse(res) {
    console.log(res);
    setMessage(res.data.message);
  }

  function errorResponse(err) {
    console.log("errrrrrr: " + err);
  }

  return (
    <div className="WelcomeComponent">
      <h1>Welcome ~ {username}</h1>
      <div>
        mananger yourtodos. -<Link to="/todos">go here</Link>
      </div>
      <div>
        <button className="btn btn-success" onClick={callHelloWorldApi}>
          call hello world rest api
        </button>
      </div>
      <div className="text-info">{message}</div>
    </div>
  );
}
