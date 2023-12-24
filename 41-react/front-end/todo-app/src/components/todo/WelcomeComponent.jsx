import { Link, useParams } from "react-router-dom";

export default function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="WelcomeComponent">
      <h1>Welcome ~ {username}</h1>
      <div>
        mananger yourtodos. -<Link to="/todos">go here</Link>
      </div>
    </div>
  );
}
