import { useState } from "react";
import "./Counter.css";
import { PropTypes } from "prop-types";

export default function CounterButton({ by, increMethod, deM }) {
  const [count, setCount] = useState(0); //const [firstelt, seceltfunction]=array
  function incrementCounterFunction() {
    // console.log(state); //[0,f]
    // state[1](state[0] + 1);
    setCount(count + by);
    increMethod(by);
    // console.log("increment  clicked " + count);
  }

  function decrementCounterFunction() {
    // console.log(state); //[0,f]
    // state[1](state[0] + 1);
    setCount(count - by);
    deM(by);
    //console.log("increment  clicked " + count);
  }

  return (
    <div className="Counter">
      <div>
        <button className="counterButton" onClick={incrementCounterFunction}>
          +{by}
        </button>
        <button className="counterButton" onClick={decrementCounterFunction}>
          -{by}
        </button>
      </div>
    </div>
  );
}

CounterButton.propTypes = {
  by: PropTypes.number,
};

CounterButton.defaultProps = {
  by: 1,
};
