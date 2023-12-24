export default function ListTodosComponent() {
  const today = new Date();

  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );
  const todos = [
    {
      id: 1,
      desc: "Learn AWS",
      done: false,
      targetDate: targetDate,
    },
    {
      id: 2,
      desc: "Learn full",
      done: false,
      targetDate: targetDate,
    },
    {
      id: 3,
      desc: "Learn Cloud",
      done: false,
      targetDate: targetDate,
    },
  ];
  return (
    <div className="container">
      <h1>things you want to have fun with</h1>
      <div>
        <table className="table">
          <thead>
            <tr>
              <td>Id</td>
              <td>Desc</td>
              <td>Is Done?</td>
              <td>Target Date</td>
            </tr>
          </thead>

          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.desc}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
