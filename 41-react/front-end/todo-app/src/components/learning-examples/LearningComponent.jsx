import FirstComponent from "./FirstComponent";
import { FifthComponent } from "./FirstComponent";
import SecComponent from "./SecComponent";
import ThirdComponent from "./ThirdComponent";
import FourComponent from "./FourComponent";
import LearningJS from "./LearningJS";

export default function LearningComponent() {
  return (
    <div className="App">
      <FirstComponent />
      <SecComponent />
      <ThirdComponent />
      <FourComponent />
      <FifthComponent />
      <LearningJS />
    </div>
  );
}
