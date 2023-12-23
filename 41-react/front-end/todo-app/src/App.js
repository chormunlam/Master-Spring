import "./App.css";
import TodoApp from "./components/todo/TodoApp";
import Counter from "./components/counter/Counter";
//import LearningComponent from "./components/learning-examples/LearningComponent";
function App() {
  return (
    <div className="App">
      {/* <PlayingWithProps p1="v1" p2="v2" /> */}
      {/* <Counter /> */}
      <TodoApp />
    </div>
  );
}

// function PlayingWithProps(pp) {
//   console.log(pp.p1);

//   return <div> {pp.p1} </div>;
// }

export default App;
