import { useState } from "react";
import "./Counter.css";
import CounterButton from "./CounterButton";

export default function Counter() {
  const [count, setCount] = useState(0); //const [firstelt, seceltfunction]=array
  function incrementCounterParentfunction(by) {
    setCount(count + by);
  }

  function decrementCounterParentfunction(by) {
    setCount(count - by);
  }
  function resetCounter() {
    setCount(0);
  }
  return (
    <>
      <span className="count"> {count}</span>
      <CounterButton
        increMethod={incrementCounterParentfunction}
        deM={decrementCounterParentfunction}
      />
      <CounterButton
        by={3}
        increMethod={incrementCounterParentfunction}
        deM={decrementCounterParentfunction}
      />
      <CounterButton
        by={7}
        increMethod={incrementCounterParentfunction}
        deM={decrementCounterParentfunction}
      />

      <button
        className="counterButton"
        style={{ backgroundColor: "purple" }}
        onClick={resetCounter}
      >
        Reset
      </button>
    </>
  );
}
