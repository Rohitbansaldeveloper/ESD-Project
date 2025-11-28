import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import Navbar from "../layout/Navbar";
export default function Home() {
  const [users, setUsers] = useState([]);

  const { domain_id } = useParams()

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/v1/domain",
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          Accept: 'application/json',
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*',
        },
      });
    console.log(result.data);
    setUsers(result.data);
    console.log(users.domain_id);
  };

  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8080/api/v1/domain/${id}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        Accept: 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
      },
    });
    loadUsers();
  };

  useEffect(() => {
    loadUsers();
  }, []);


  return (
    <div> <Navbar />
      <div className="container">
        <div className="py-4">
          <table className="table border shadow">
            <thead>
              <tr>
                <th scope="col">Domain ID</th>
                <th scope="col">Program Name</th>
                <th scope="col">Batch</th>
                <th scope="col">Capacity</th>
                <th scope="col">Qualification</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              {users.map((user) => (
                <tr>
                  <th scope="row" key={user.domain_id}>
                    {user.domain_id}
                  </th>
                  <td>{user.program}</td>
                  <td>{user.batch}</td>
                  <td>{user.capacity}</td>
                  <td>{user.qualification}</td>
                  <td>
                    <Link className="btn btn-primary mx-2" to={`/ViewStudents/${user.domain_id}`} >
                      View Students
                    </Link>
                    <Link className="btn btn-outline-primary mx-2" to={`/editDomain/${user.domain_id}`}>
                      Edit
                    </Link>
                    <button className="btn btn-danger mx-2" onClick={() => deleteUser(user.domain_id)} >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="container">
          <Link className="btn btn-danger mx-2" to="/addDomain">
            Add  New Domain
          </Link>
        </div>
      </div>
    </div>

  );
}
