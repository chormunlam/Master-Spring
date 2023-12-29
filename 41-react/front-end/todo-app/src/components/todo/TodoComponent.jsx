import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  retrieveTodoApi,
  updateTodoApi,
  createTodoApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { Formik, Form, Field, ErrorMessage } from "formik";
export default function TodoComponent() {
  const { id } = useParams();
  const authContext = useAuth();
  const nav = useNavigate();
  const username = authContext.username;

  const [description, setDesc] = useState("");
  const [targetDate, setTargetDate] = useState("");

  /* eslint-disable */
  useEffect(() => retrieveTodo(), [id]);

  function retrieveTodo() {
    if (id != -1) {
      retrieveTodoApi(username, id)
        .then((res) => {
          setDesc(res.data.description);
          setTargetDate(res.data.targetDate);
        })
        .catch((err) => console.log(err));
    }
  }

  function onSubmit(values) {
    const todo = {
      id: id,
      username: username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };
    if (id == -1) {
      createTodoApi(username, todo)
        .then((res) => {
          nav("/todos");
        })
        .catch((err) => console.log(err));
    } else {
      updateTodoApi(username, id, todo)
        .then((res) => {
          nav("/todos");
        })
        .catch((err) => console.log(err));
    }
    //console.log(todo);
  }

  function validate(values) {
    let errors = {
      // description: "enter vaild desc",
      // targetDate: "enter a valid target date",
    };
    if (values.description.length < 3) {
      errors.description = "enter vaild desc, at least 1 chart";
    }

    if (values.targetDate == null || values.targetDate == "") {
      errors.targetDate = "enter vaild target date";
    }
    // console.log(values);
    return errors;
  }

  return (
    <div>
      <h1>
        Enter the to-do wish that the whole world will help you to complete
      </h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnBlur={false}
          validateOnChange={false}
        >
          {(props) => (
            // Your Formik component content goes here
            // For example:
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />

              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Descripton</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                />
              </fieldset>

              <fieldset className="form-group">
                <label>target date</label>
                <Field type="date" className="form-control" name="targetDate" />
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
