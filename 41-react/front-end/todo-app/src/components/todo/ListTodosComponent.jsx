import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  retrieveAllTodosForUsernameApi,
  deleteTodoApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
export default function ListTodosComponent() {
  const today = new Date();

  const authContext = useAuth();

  const username = authContext.username;

  const navigate = useNavigate();

  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );

  //useEffect(() => refreshTodos());
  useEffect(() => {
    refreshTodos();
  }, []); // Ensure the dependency array is correct or contains only necessary variables

  function refreshTodos() {
    retrieveAllTodosForUsernameApi(username)
      .then((res) => {
        // console.log(res.data);
        setTodos(res.data);
      })
      .catch((err) => console.log(err));
  }
  const [todos, setTodos] = useState([]);
  const [mess, setMess] = useState(null);

  function deleteTodo(id) {
    console.log("delete todo called" + id);
    deleteTodoApi(username, id)
      .then((res) => {
        //1. display message
        setMess("delete id: " + id + " successfully! ");
        //2. update todos
        refreshTodos();
      })
      .catch((err) => console.log(err));
  }

  function updateTodo(id) {
    console.log("update todo called" + id);
    navigate(`/todo/${id}`);

    // deleteTodoApi(username, id)
    //   .then((res) => {
    //     //1. display message
    //     setMess("delete id: " + id + " successfully! ");
    //     //2. update todos
    //     refreshTodos();
    //   })
    //   .catch((err) => console.log(err));
  }

  // const todos = [
  //   {
  //     id: 1,
  //     desc: "Learn AWS",
  //     done: false,
  //     targetDate: targetDate,
  //   },
  //   {
  //     id: 2,
  //     desc: "Learn full",
  //     done: false,
  //     targetDate: targetDate,
  //   },
  //   {
  //     id: 3,
  //     desc: "Learn Cloud",
  //     done: false,
  //     targetDate: targetDate,
  //   },
  // ];

  function addNewTodo() {
    navigate(`/todo/-1`);
  }
  return (
    <div className="container">
      <h1>things you want to have fun with</h1>

      {mess && <div className="alert alert-warning">{mess}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              {/* <th>Id</th> */}
              <th>Desc</th>
              <th>Is Done?</th>
              <th>Target Date</th>
              <th>Delete</th>
              <th>Update</th>
            </tr>
          </thead>

          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                {/* <td>{todo.id}</td> */}
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toString()}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="btn btn-success m-3" onClick={addNewTodo}>
        Add to do
      </div>
    </div>
  );
}
